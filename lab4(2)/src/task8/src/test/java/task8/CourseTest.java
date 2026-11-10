package task8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CourseTest{
    @Test
    void completeHours_addsHours_whenAmountFitsRemainingDuration(){
        // Arrange
        Course course = new Course(100, 20);

        // Act
        course.completeHours(30);

        // Assert
        assertEquals(50, course.completedHours());
    }

    @Test
    void completeHours_throwsIllegalArgumentException_whenAmountIsNotPositive(){
        // Arrange
        Course course = new Course(100, 20);

        // Act
        Executable action = () -> course.completeHours(-1);

        // Assert
        assertThrows(IllegalArgumentException.class, action);
    }
}
