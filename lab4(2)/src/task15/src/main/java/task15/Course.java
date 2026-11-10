package task15;

import java.util.Objects;

final class Course {
    static final int MIN_DURATION_HOURS = 1;
    static final int MAX_DURATION_HOURS = 500;

    private final CourseCode code;
    private final String title;
    private final int durationHours;
    private final CourseStatus status;
    private final int capacity;
    private int enrolledCount;

    Course(CourseCode code, String title, int durationHours,
            CourseStatus status, int capacity) {
        this.code = Objects.requireNonNull(code);
        this.status = Objects.requireNonNull(status);

        if (title == null || title.isBlank()) {
            throw new DomainValidationException("Course title is required");
        }
        if (durationHours < MIN_DURATION_HOURS
                || durationHours > MAX_DURATION_HOURS) {
            throw new DomainValidationException(
                    "Duration must be between 1 and 500 hours"
            );
        }
        if (capacity < 0) {
            throw new DomainValidationException("Capacity cannot be negative");
        }

        this.title = title.strip();
        this.durationHours = durationHours;
        this.capacity = capacity;
    }

    CourseCode code() {
        return code;
    }

    String title() {
        return title;
    }

    int durationHours() {
        return durationHours;
    }

    CourseStatus status() {
        return status;
    }

    int capacity() {
        return capacity;
    }

    int enrolledCount() {
        return enrolledCount;
    }

    boolean hasAvailableSeat() {
        return enrolledCount < capacity;
    }

    void enroll() {
        if (!hasAvailableSeat()) {
            throw new IllegalStateException("Course capacity exceeded");
        }
        enrolledCount++;
    }
}
