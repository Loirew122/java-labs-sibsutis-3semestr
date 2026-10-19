package src.task8;

import src.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCourseRepository implements CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public Optional<Course> findById(long id) {
        return courses.stream().filter(c -> c.id() == id).findFirst();
    }

    @Override
    public List<Course> findAll() {
        return List.copyOf(courses);
    }

    @Override
    public void save(Course course) {
        courses.add(course);
    }
}
