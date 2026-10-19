package src.task8;

import src.Course;

import java.util.List;
import java.util.Optional;

// только чтение: этот контракт может честно выполнить любая реализация
public interface CourseReader {
    Optional<Course> findById(long id);

    List<Course> findAll();
}
