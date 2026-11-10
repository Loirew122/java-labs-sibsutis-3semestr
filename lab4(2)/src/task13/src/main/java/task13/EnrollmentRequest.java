package task13;
class EnrollmentRequest{
    private boolean duplicate;
    private boolean prerequisiteCompleted;

    EnrollmentRequest(boolean duplicate, boolean prerequisiteCompleted) {
        this.duplicate = duplicate;
        this.prerequisiteCompleted = prerequisiteCompleted;
    }
    boolean duplicate(){ return duplicate;}
    boolean prerequisiteCompleted(){ return prerequisiteCompleted;}
    void enrolled(){ duplicate = true;}
}