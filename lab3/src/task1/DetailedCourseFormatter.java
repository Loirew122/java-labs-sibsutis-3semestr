package src.task1;

import src.Course;

public class DetailedCourseFormatter implements CourseFormatter{
    @Override
    public String format(Course course){
        return String.format("id - %d, title - %s, dur. hours - %d, com. hourse %d%n" +
                        "is done - %b, rem. hours - %d",
                course.id(), course.title(), course.durationHours(), course.completedHours(),
                course.isCompleted(), course.remainingHours());
    }
    public int extra(){
        return 52;
    }
}
