package task12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseRepositoryTest {
    private CourseRepository repository;
    @BeforeEach
    void setUp(){
        repository = new CourseRepository();
    }
    @Test
    void save_addsCourse() {
        repository.save(new Course("JAVA101", "Java Basics"));
        assertEquals(1, repository.size());
    }

    @Test
    void findByCode_validCourseTitle_whenCourseSaveAndFindByCode() {
        repository.save(new Course("JAVA101", "Java Basics"));

        Course course = repository.findByCode("JAVA101").orElseThrow();
        assertEquals("Java Basics", course.title());
    }
}
