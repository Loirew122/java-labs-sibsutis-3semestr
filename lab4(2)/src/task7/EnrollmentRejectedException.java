package task7;
class EnrollmentRejectedException extends Exception{
    EnrollmentRejectedException(){
        super("It is not possible to register for the course");
    }
}