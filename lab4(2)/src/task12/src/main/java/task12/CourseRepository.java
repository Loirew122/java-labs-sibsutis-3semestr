package task12;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

final class CourseRepository {
    private final Map<String, Course> courses = new LinkedHashMap<>();

    void save(Course course) {
        courses.put(course.code(), course);
    }

    Optional<Course> findByCode(String code) {
        return Optional.ofNullable(courses.get(code));
    }

    int size() {
        return courses.size();
    }
}
