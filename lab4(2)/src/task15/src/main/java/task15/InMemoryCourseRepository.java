package task15;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

final class InMemoryCourseRepository implements CourseRepository {
    private final Map<CourseCode, Course> courses = new LinkedHashMap<>();

    @Override
    public void addAll(List<Course> importedCourses) {
        for (Course course : importedCourses) {
            courses.put(course.code(), course);
        }
    }

    @Override
    public Optional<Course> findByCode(CourseCode code) {
        return Optional.ofNullable(courses.get(code));
    }

    @Override
    public int size() {
        return courses.size();
    }

    List<Course> courses() {
        return List.copyOf(courses.values());
    }
}
