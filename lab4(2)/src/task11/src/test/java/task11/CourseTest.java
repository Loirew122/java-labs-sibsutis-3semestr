package task11;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class CourseTest{
    @Test
    void completeHours_throwsHoursCompleteException_whenHoursExceedRemaining(){
        Course course = new Course(100, 50);
        int hours = 60;
        Executable action = ()-> course.completeHours(hours);
        
        HoursCompleteException  exception =
         assertThrows(HoursCompleteException.class, action);
        int requested = 60;
        int remaining = 50;
        int completedHours = 50;
        assertEquals(completedHours, course.completedHours());
        assertEquals(requested, exception.requestedHours());
        assertEquals(remaining, exception.remainingHours());

    }
}