package task14;

import java.util.ArrayList;
import java.util.List;

final class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    void addAll(List<Course> importedCourses) {
        courses.addAll(importedCourses);
    }

    int size() {
        return courses.size();
    }

    List<Course> courses() {
        return List.copyOf(courses);
    }
}
