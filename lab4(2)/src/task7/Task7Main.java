package task7;
import java.util.Optional;

class Task7Main{
        
    public static void main(String[] args) {
        Course course1 = new Course("ABC", 1, true);
        Optional<Course> found  = course1.findCourse(1);
        Optional<Course> notFound  = course1.findCourse(2);
        //1 существующий id 
        found.ifPresentOrElse(value -> System.out.println("Course found : " + value),
        ()-> System.out.println("Course not found")
        );
        // 2 неизвестный id (Optional.empty())
        notFound.ifPresentOrElse(value -> System.out.println("Course found : " + value),
        ()-> System.out.println("Course not found")
        );
        //3 успешное зачисление 
        try {course1.enroll(); }
        catch (EnrollmentRejectedException e ) { 
            System.out.println(e.getMessage());
        }
        Course course2 = new Course("EFG", 2, false);
        // 4 зачисление - отказ 
        try {course2.enroll(); }
        catch (EnrollmentRejectedException e ) { 
            System.out.println(e.getMessage());
        } 
    }
}
/*
Способ сообщения о неуспехе зависит от его смысла:

Optional — отсутствие результата нормально;
Result — ожидаемый отказ требует подробного описания;
checked exception — операция не выполнена, вызывающий обязан это обработать;
unchecked exception — нарушен контракт метода, обычно это ошибка программиста.
*/
