package src.task1;

import src.Course;

public class CompactCourseFormatter implements CourseFormatter {
    @Override
    public String format(Course course){
        return String.format("id - %d, title - %s", course.id(), course.title());
    }
}
