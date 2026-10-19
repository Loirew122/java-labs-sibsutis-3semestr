package src.task3;
import src.Course;
import src.task1.CompactCourseFormatter;
import src.task1.CourseFormatter;
import src.task1.DetailedCourseFormatter;

public class Task3Main {
    public static void main(String[] args){
        Course course = new Course(10, "Java Fundamentals", 32, 6);
        CourseFormatter[] formatters = {
                new CompactCourseFormatter(),
                new DetailedCourseFormatter(),
                new ThirdCourseFormatter()
        } ;
        for(CourseFormatter f : formatters){
            System.out.println("coruse: " +f.format(course));
        }
    }
}
