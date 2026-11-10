package task15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImportUseCaseTest {
    private InMemoryCourseRepository repository;
    private CourseImporter importer;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCourseRepository();
        importer = new CourseImporter(repository);
    }

    @Test
    void importCourses_importsAllValidRecords() throws Exception {
        int processed = importer.importCourses(new StringReader(validInput()));

        assertEquals(2, processed);
        assertEquals(2, repository.size());
    }

    @Test
    void importCourses_reportsMalformedRecord() {
        CourseImportException exception = importMalformed(
                new StringReader(inputWithMalformedRecord())
        );

        assertEquals(
                ErrorCode.IMPORT_MALFORMED_RECORD,
                exception.errorCode()
        );
    }

    @Test
    void importCourses_preservesMalformedCause() {
        CourseImportException exception = importMalformed(
                new StringReader(inputWithMalformedRecord())
        );

        assertInstanceOf(IllegalArgumentException.class, exception.getCause());
    }

    @Test
    void importCourses_reportsRecordNumberAndProcessedCount() {
        CourseImportException exception = importMalformed(
                new StringReader(inputWithMalformedRecord())
        );

        assertEquals(2, exception.recordNumber());
        assertEquals(1, exception.processedCount());
    }

    @Test
    void importCourses_closesReaderAfterSuccess() throws Exception {
        TrackingReader reader = new TrackingReader(validInput());

        importer.importCourses(reader);

        assertTrue(reader.closed());
    }

    @Test
    void importCourses_preservesCloseFailureAsSuppressed() {
        CloseFailingReader reader = new CloseFailingReader(
                inputWithMalformedRecord()
        );

        CourseImportException exception = importMalformed(reader);

        assertEquals(1, exception.getSuppressed().length);
        assertInstanceOf(IOException.class, exception.getSuppressed()[0]);
        assertTrue(reader.closed());
    }

    @Test
    void importCourses_doesNotPublishPartialResult() {
        importMalformed(new StringReader(inputWithMalformedRecord()));

        assertEquals(0, repository.size());
    }

    private CourseImportException importMalformed(Reader reader) {
        return assertThrows(
                CourseImportException.class,
                () -> importer.importCourses(reader)
        );
    }

    private String validInput() {
        return "JAVA101;Java Basics;100;OPEN;10\n"
                + "DB200;Databases;80;OPEN;8";
    }

    private String inputWithMalformedRecord() {
        return "JAVA101;Java Basics;100;OPEN;10\nBROKEN";
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

    private static final class CloseFailingReader extends Reader {
        private final StringReader delegate;
        private boolean closed;

        CloseFailingReader(String content) {
            delegate = new StringReader(content);
        }

        @Override
        public int read(char[] buffer, int offset, int length)
                throws IOException {
            return delegate.read(buffer, offset, length);
        }

        @Override
        public void close() throws IOException {
            closed = true;
            delegate.close();
            throw new IOException("Reader close failed");
        }

        boolean closed() {
            return closed;
        }
    }
}
