package task15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class CourseHubFacadeTest {
    @Test
    void enroll_mapsValidationFailureToStableCode() {
        CourseHubFacade facade = facade(new InMemoryCourseRepository());

        OperationResult<Course> result = facade.enroll(
                "broken", request(false, true)
        );

        assertFalse(result.successful());
        assertEquals(ErrorCode.VALIDATION_ERROR, result.errorCode());
    }

    @Test
    void enroll_preservesEnrollmentRejectionCode() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        repository.addAll(List.of(course(0)));
        CourseHubFacade facade = facade(repository);

        OperationResult<Course> result = facade.enroll(
                "JAVA101", request(false, true)
        );

        assertEquals(ErrorCode.COURSE_FULL, result.errorCode());
    }

    @Test
    void importCourses_mapsMalformedRecordToStableCode() {
        CourseHubFacade facade = facade(new InMemoryCourseRepository());

        OperationResult<Integer> result = facade.importCourses(
                new StringReader("BROKEN")
        );

        assertEquals(ErrorCode.IMPORT_MALFORMED_RECORD, result.errorCode());
        assertInstanceOf(CourseImportException.class, result.cause());
    }

    @Test
    void importCourses_mapsIoFailureToStableCode() {
        CourseHubFacade facade = facade(new InMemoryCourseRepository());

        OperationResult<Integer> result = facade.importCourses(
                new ReadFailingReader()
        );

        assertEquals(ErrorCode.IMPORT_IO_ERROR, result.errorCode());
    }

    @Test
    void enroll_mapsRepositoryFailureToInfrastructureCode() {
        CourseHubFacade facade = facade(new InfrastructureFailingRepository());

        OperationResult<Course> result = facade.enroll(
                "JAVA101", request(false, true)
        );

        assertEquals(
                ErrorCode.INFRASTRUCTURE_UNAVAILABLE,
                result.errorCode()
        );
        assertInstanceOf(InfrastructureException.class, result.cause());
    }

    @Test
    void enroll_doesNotHideProgrammingError() {
        CourseHubFacade facade = facade(new ProgrammingFailingRepository());

        assertThrows(
                IllegalStateException.class,
                () -> facade.enroll("JAVA101", request(false, true))
        );
    }

    private CourseHubFacade facade(CourseRepository repository) {
        return new CourseHubFacade(repository);
    }

    private Course course(int capacity) {
        return new Course(
                new CourseCode("JAVA101"),
                "Java Basics",
                100,
                CourseStatus.OPEN,
                capacity
        );
    }

    private EnrollmentRequest request(
            boolean duplicate, boolean prerequisiteCompleted) {
        return new EnrollmentRequest(
                "student-42", duplicate, prerequisiteCompleted
        );
    }

    private static final class ReadFailingReader extends Reader {
        @Override
        public int read(char[] buffer, int offset, int length)
                throws IOException {
            throw new IOException("Read failed");
        }

        @Override
        public void close() {
        }
    }

    private static final class InfrastructureFailingRepository
            implements CourseRepository {
        @Override
        public void addAll(List<Course> courses)
                throws InfrastructureException {
            throw unavailable();
        }

        @Override
        public Optional<Course> findByCode(CourseCode code)
                throws InfrastructureException {
            throw unavailable();
        }

        @Override
        public int size() {
            return 0;
        }

        private InfrastructureException unavailable() {
            return new InfrastructureException(
                    "Repository unavailable",
                    new IOException("Connection failed")
            );
        }
    }

    private static final class ProgrammingFailingRepository
            implements CourseRepository {
        @Override
        public void addAll(List<Course> courses) {
            throw new IllegalStateException("Programming error");
        }

        @Override
        public Optional<Course> findByCode(CourseCode code) {
            throw new IllegalStateException("Programming error");
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
