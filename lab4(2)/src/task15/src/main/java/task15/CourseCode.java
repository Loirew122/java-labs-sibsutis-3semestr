package task15;

import java.util.Locale;

record CourseCode(String name) {
    CourseCode {
        if (name == null) {
            throw new DomainValidationException("Course code is required");
        }

        name = name.strip().toUpperCase(Locale.ROOT);
        if (!name.matches("[A-Z]{2,8}[0-9]{3}")) {
            throw new DomainValidationException("Invalid course code");
        }
    }
}
