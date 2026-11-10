package task14;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseImporterTest {
    private CourseRepository repository;
    private CourseImporter importer;

    @BeforeEach
    void setUp() {
        repository = new CourseRepository();
        importer = new CourseImporter(repository);
    }

    @Test
    void importCourses_importsAllCourses_whenInputIsValid()
            throws CourseImportException {
        TrackingReader reader = new TrackingReader(
                "JAVA101;Java Basics\nDB201;Databases"
        );

        ImportResult result = importer.importCourses(reader);
        List<Course> courses = repository.courses();

        assertEquals(2, result.processedCount());
        assertEquals(2, repository.size());
        assertEquals("JAVA101", courses.get(0).code());
        assertEquals("Java Basics", courses.get(0).title());
        assertEquals("DB201", courses.get(1).code());
        assertEquals("Databases", courses.get(1).title());
        assertTrue(reader.closed());
    }

    @Test
    void importCourses_reportsMalformedRecord_withoutPublishingCourses() {
        TrackingReader reader = new TrackingReader(
                "JAVA101;Java Basics\nBROKEN"
        );

        CourseImportException exception = assertThrows(
                CourseImportException.class,
                () -> importer.importCourses(reader)
        );

        assertEquals(2, exception.recordNumber());
        assertEquals(1, exception.processedCount());
        assertInstanceOf(IllegalArgumentException.class, exception.getCause());
        assertEquals(0, repository.size());
        assertTrue(reader.closed());
    }

    @Test
    void importCourses_preservesCloseFailureAsSuppressed_whenRecordIsMalformed() {
        CloseFailingReader reader = new CloseFailingReader(
                "JAVA101;Java Basics\nBROKEN"
        );

        CourseImportException exception = assertThrows(
                CourseImportException.class,
                () -> importer.importCourses(reader)
        );
        Throwable[] suppressed = exception.getSuppressed();

        assertEquals(2, exception.recordNumber());
        assertEquals(1, exception.processedCount());
        assertInstanceOf(IllegalArgumentException.class, exception.getCause());
        assertEquals(1, suppressed.length);
        assertInstanceOf(IOException.class, suppressed[0]);
        assertEquals("Reader close failed", suppressed[0].getMessage());
        assertEquals(0, repository.size());
        assertTrue(reader.closed());
    }

    @Test
    void importCourses_publishesNothing_whenReaderCloseFails() {
        CloseFailingReader reader = new CloseFailingReader(
                "JAVA101;Java Basics\nDB201;Databases"
        );

        CourseImportException exception = assertThrows(
                CourseImportException.class,
                () -> importer.importCourses(reader)
        );

        assertEquals(2, exception.processedCount());
        assertInstanceOf(IOException.class, exception.getCause());
        assertEquals(0, repository.size());
        assertTrue(reader.closed());
    }

    private static final class TrackingReader extends StringReader {
        private boolean closed;

        TrackingReader(String content) {
            super(content);
        }

        @Override
        public void close() {
            closed = true;
            super.close();
        }

        boolean closed() {
            return closed;
        }
    }
}
