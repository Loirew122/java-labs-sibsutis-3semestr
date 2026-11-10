package task3;
class  EnrollmentRejectedException extends Exception{
    enum RejectionReasons{
        COURSE_FULL, COURSE_CLOSED, PREREQUISITE_MISSING, DUPLICATE_REQUEST
    }
    private int studentId;
    private int courseId;
    private RejectionReasons reason;

    EnrollmentRejectedException(int studentId, int courseId, RejectionReasons reason) {
        super("Заявка отклонена по причине " + reason);
        this.studentId = studentId;
        this.courseId = courseId;
        this.reason = reason;

    }
    EnrollmentRejectedException(int studentId, int courseId, RejectionReasons reason, Throwable cause) {
        super("Заявка отклонена по причине " + reason, cause);

        this.studentId = studentId;
        this.courseId = courseId;
        this.reason = reason;
    }
    int studentId(){return studentId;}
    int courseId(){return courseId;}
    RejectionReasons reason(){ return reason;}

    @Override 
    public String toString(){
        return "Заявка отклонена.";
    }
}