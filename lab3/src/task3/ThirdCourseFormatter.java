package src.task3;
import src.Course;
import src.task1.CourseFormatter;

public class ThirdCourseFormatter implements CourseFormatter {
    @Override
    public String format(Course course){
        return String.format("%s  - %b done ?", course.title(), course.isCompleted());
    }
}
