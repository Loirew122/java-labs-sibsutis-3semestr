package task15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EnrollmentUseCaseTest {
    private final EnrollmentService service = new EnrollmentService();

    @Test
    void enroll_increasesCount_whenRequestIsAllowed()
            throws EnrollmentRejectedException {
        Course course = course(CourseStatus.OPEN, 2);

        service.enroll(course, request(false, true));

        assertEquals(1, course.enrolledCount());
    }

    @Test
    void enroll_rejectsClosedCourse() {
        EnrollmentRejectedException exception = assertThrows(
                EnrollmentRejectedException.class,
                () -> service.enroll(
                        course(CourseStatus.CLOSED, 2),
                        request(false, true)
                )
        );

        assertEquals(ErrorCode.COURSE_NOT_OPEN, exception.errorCode());
    }

    @Test
    void enroll_rejectsDuplicateRequest() {
        EnrollmentRejectedException exception = assertThrows(
                EnrollmentRejectedException.class,
                () -> service.enroll(
                        course(CourseStatus.OPEN, 2),
                        request(true, true)
                )
        );

        assertEquals(ErrorCode.ALREADY_ENROLLED, exception.errorCode());
    }

    @Test
    void enroll_rejectsMissingPrerequisite() {
        EnrollmentRejectedException exception = assertThrows(
                EnrollmentRejectedException.class,
                () -> service.enroll(
                        course(CourseStatus.OPEN, 2),
                        request(false, false)
                )
        );

        assertEquals(ErrorCode.PREREQUISITE_MISSING, exception.errorCode());
    }

    @Test
    void enroll_rejectsFullCourse() {
        EnrollmentRejectedException exception = assertThrows(
                EnrollmentRejectedException.class,
                () -> service.enroll(
                        course(CourseStatus.OPEN, 0),
                        request(false, true)
                )
        );

        assertEquals(ErrorCode.COURSE_FULL, exception.errorCode());
    }

    @Test
    void enroll_doesNotChangeCount_whenRequestIsRejected() {
        Course course = course(CourseStatus.OPEN, 2);

        assertThrows(EnrollmentRejectedException.class,
                () -> service.enroll(course, request(true, true)));

        assertEquals(0, course.enrolledCount());
    }

    @Test
    void rejectionMessage_doesNotExposeStudentOrCourseId() {
        Course course = course(CourseStatus.OPEN, 0);
        EnrollmentRequest request = new EnrollmentRequest(
                "student-42", false, true
        );

        EnrollmentRejectedException exception = assertThrows(
                EnrollmentRejectedException.class,
                () -> service.enroll(course, request)
        );

        assertFalse(exception.getMessage().contains("student-42"));
        assertFalse(exception.getMessage().contains("JAVA101"));
    }

    private Course course(CourseStatus status, int capacity) {
        return new Course(
                new CourseCode("JAVA101"),
                "Java Basics",
                100,
                status,
                capacity
        );
    }

    private EnrollmentRequest request(
            boolean duplicate, boolean prerequisiteCompleted) {
        return new EnrollmentRequest(
                "student-42", duplicate, prerequisiteCompleted
        );
    }
}
