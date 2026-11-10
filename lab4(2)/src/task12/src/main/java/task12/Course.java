package task12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

final class Course {
    private final String code;
    private final String title;

    Course(String code, String title) {
        this.code = Objects.requireNonNull(code);
        this.title = Objects.requireNonNull(title);
    }

    static Course read(Path path) throws IOException {
        String[] parts = Files.readString(path).strip().split(";", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Course must contain code and title");
        }
        return new Course(parts[0], parts[1]);
    }

    String code() {
        return code;
    }

    String title() {
        return title;
    }

    @Override
    public String toString() {
        return "Course{code='" + code + "', title='" + title + "'}";
    }
}
