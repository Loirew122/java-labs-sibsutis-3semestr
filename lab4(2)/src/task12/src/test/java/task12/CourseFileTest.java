package task12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class CourseFileTest {
    @TempDir
    Path tempDir;
    @Test
    void read_returnsCourse_whenFileContainsValidData() throws IOException {
        Path path = tempDir.resolve("java_text.txt") ;
        Files.writeString(path, "JAVA101;Java Basics");
        Course course = Course.read(path);

        assertEquals("JAVA101", course.code());
        assertEquals("Java Basics", course.title());
    }
}
