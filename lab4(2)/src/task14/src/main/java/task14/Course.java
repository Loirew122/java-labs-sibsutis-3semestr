package task14;

import java.util.Objects;

final class Course {
    private final String code;
    private final String title;

    Course(String code, String title) {
        this.code = Objects.requireNonNull(code);
        this.title = Objects.requireNonNull(title);
    }

    String code() {
        return code;
    }

    String title() {
        return title;
    }
}
