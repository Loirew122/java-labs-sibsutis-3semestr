package task9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CourseBoundaryTest{
    @Test
    void constructor_throwsIllegalArgumentException_whenDurationIsBelowMinimum(){
        // Arrange
        int duration = 0;

        // Act
        Executable action = () -> new Course(duration, 0);

        // Assert
        assertThrows(IllegalArgumentException.class, action);
    }

    @Test
    void constructor_acceptsDuration_whenDurationEqualsMinimum(){
        // Arrange
        int duration = 1;

        // Act
        Course course = new Course(duration, 0);

        // Assert
        assertEquals(1, course.durationHours());
    }

    @Test
    void constructor_acceptsDuration_whenDurationEqualsMaximum(){
        // Arrange
        int duration = 500;

        // Act
        Course course = new Course(duration, 0);

        // Assert
        assertEquals(500, course.durationHours());
    }

    @Test
    void constructor_throwsIllegalArgumentException_whenDurationIsAboveMaximum(){
        // Arrange
        int duration = 501;

        // Act
        Executable action = () -> new Course(duration, 0);

        // Assert
        assertThrows(IllegalArgumentException.class, action);
    }
}
