package task12;

class Task12Main {
    public static void main(String[] args) {
        CourseRepository repository = new CourseRepository();
        repository.save(new Course("JAVA101", "Java Basics"));

        Course course = repository.findByCode("JAVA101").orElseThrow();
        System.out.println(course.code() + ": " + course.title());
    }
}
