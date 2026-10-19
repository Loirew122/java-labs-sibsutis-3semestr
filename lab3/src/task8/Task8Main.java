package src.task8;

import src.Course;

public class Task8Main {
    // клиент рассчитывает на контракт Repo: save должен сохранять
    static void importCourse(BadCourseRepository.Repo repo, Course course) {
        repo.save(course);
    }

    // та же задача на новых интерфейсах: тип параметра гарантирует, что save есть
    static void importCourse(CourseRepository repo, Course course) {
        repo.save(course);
    }

    public static void main(String[] args) {
        Course course = new Course(1, "Java", 40, 0);

        try {
            importCourse(new BadCourseRepository.BadReadOnlyRepo(), course);
        } catch (UnsupportedOperationException e) {
            System.out.println("старый дизайн: падает в рантайме, " + e.getMessage());
        }

        InMemoryCourseRepository store = new InMemoryCourseRepository();
        importCourse(store, course);

        // importCourse(readOnly, course) не скомпилируется: ReadOnlyCourseRepository не CourseRepository
        CourseReader readOnly = new ReadOnlyCourseRepository(store);
        System.out.println("новый дизайн: читаем " + readOnly.findAll().size() + " курс, "
                + readOnly.findById(1).map(Course::title).orElse("?"));
    }
}
