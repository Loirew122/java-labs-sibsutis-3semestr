package src.task8;

import src.Course;

import java.util.List;
import java.util.Optional;

// реализует только CourseReader: метода save у него нет, поэтому нет и невыполнимого обещания
public class ReadOnlyCourseRepository implements CourseReader {
    private final CourseReader source;

    public ReadOnlyCourseRepository(CourseReader source) {
        this.source = source;
    }

    @Override
    public Optional<Course> findById(long id) {
        return source.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return source.findAll();
    }
}
