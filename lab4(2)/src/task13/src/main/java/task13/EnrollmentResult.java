package task13;
class EnrollmentResult{
    private boolean successful;
    private RejectionReason reason;

    public EnrollmentResult() {
    }
    
    void success(){
        
        this.successful = true;
    }
    void rejected(RejectionReason reason){
        this.successful = false;
        this.reason = reason;
    }
    boolean successful() {
        return successful;
    }
    RejectionReason reason() {
        return reason;
    }
    String message() {
    return successful
            ? "Enrollment successful"
            : "Enrollment rejected: " + reason;
    }


}