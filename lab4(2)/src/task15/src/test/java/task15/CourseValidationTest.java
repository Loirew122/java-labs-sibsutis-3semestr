package task15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CourseValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {" java101 ", "DB200"})
    void courseCode_normalizesValidValue(String value) {
        CourseCode code = new CourseCode(value);

        assertEquals(value.strip().toUpperCase(), code.name());
    }

    @Test
    void courseCode_rejectsBlankValue() {
        assertThrows(DomainValidationException.class,
                () -> new CourseCode("   "));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 501})
    void course_rejectsDurationOutsideRange(int durationHours) {
        assertThrows(DomainValidationException.class,
                () -> createCourse(durationHours));
    }

    @Test
    void course_acceptsMinimumDuration() {
        Course course = createCourse(1);

        assertEquals(1, course.durationHours());
    }

    private Course createCourse(int durationHours) {
        return new Course(
                new CourseCode("JAVA101"),
                "Java Basics",
                durationHours,
                CourseStatus.OPEN,
                10
        );
    }
}
