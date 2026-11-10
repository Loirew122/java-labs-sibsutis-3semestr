package task10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CourseCodeTest{
    // index  - номер запуска, 0 и 1 первый и второй параметр 
    @ParameterizedTest(name = "[{index}]\"{0}\" -> \"{1}\" ")
    // каждая строчка отдельный запуск метода
    @CsvSource({
        "'   java101  ', JAVA101", 
        "sql200, SQL200", 
        "Go300, GO300"
    })
    void constructor_normalizesValidCode(String input, String expected){
        CourseCode course = new CourseCode(input);
        String finalName  = course.name();
        assertEquals(expected, finalName);
    }
    @ParameterizedTest(name = "[{index}]\"{0}\" -> \"{1}\" ")
    @CsvSource({
        "A909, too few letters", 
        "JAVA10, only 2 numbers", 
        "JAVA4000, 4 numbers"
    })
    void constructor_throwsIllegalArgumentException_whenCodeIsInvalid(
        String input, String reason){
        String name = input;
        Executable action = () -> new CourseCode(name);
        assertThrows(IllegalArgumentException.class, action);
    }
}