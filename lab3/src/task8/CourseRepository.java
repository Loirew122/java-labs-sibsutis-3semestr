package src.task8;

import src.Course;

// чтение плюс запись: тот, кто принимает CourseRepository, вправе вызвать save
public interface CourseRepository extends CourseReader {
    void save(Course course);
}
