package task3;
import java.io.IOException;

class Task3Main{

    public static void main(String[] agrs){
        Exception lowLevelCause =
        new IOException("Не удалось прочитать данные курса");

        EnrollmentRejectedException couse1 = new EnrollmentRejectedException(1, 7, EnrollmentRejectedException.RejectionReasons.COURSE_CLOSED);
        System.out.println("1 - " + couse1.getMessage() + " студент с id : " + couse1.studentId() +
        " с номером курса : " + couse1.courseId());
        EnrollmentRejectedException couse2 = new EnrollmentRejectedException(2, 6, EnrollmentRejectedException.RejectionReasons.COURSE_FULL, lowLevelCause );
        System.out.println("2 - " + couse2.getMessage() +" исходная причина : " +  couse2.getCause() + " студент с id : " + couse2.studentId() +
        " с номером курса : " + couse2.courseId());
            
        System.out.println("course1 " + couse1.toString());
        System.out.println("course2 " + couse2.toString());
    }
}