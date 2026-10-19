package src.task8;

import src.Course;

import java.util.List;
import java.util.Optional;

// исходный плохой дизайн: CourseRepository обещает save, а подтип его не выполняет
public class BadCourseRepository {
    public interface Repo {
        Optional<Course> findById(long id);

        List<Course> findAll();

        void save(Course course);
    }

    // нарушение LSP: усиливает предусловие до "save вызывать нельзя"
    public static class BadReadOnlyRepo implements Repo {
        @Override
        public Optional<Course> findById(long id) {
            return Optional.empty();
        }

        @Override
        public List<Course> findAll() {
            return List.of();
        }

        @Override
        public void save(Course course) {
            throw new UnsupportedOperationException("read-only");
        }
    }
}
