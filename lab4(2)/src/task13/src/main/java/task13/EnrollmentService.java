package task13;
class EnrollmentService{
    
    static EnrollmentResult enroll(Course course, EnrollmentRequest request){
         EnrollmentResult result = new EnrollmentResult();
        if (course.status() != CourseStatus.OPEN){
            result.rejected(RejectionReason.COURSE_CLOSED);
        }
        else if (request.duplicate()){
            result.rejected(RejectionReason.ALREADY_ENROLLED);
        }
        else if (!request.prerequisiteCompleted()) {
            result.rejected(RejectionReason.PREREQUISITE_MISSING);
        }
        else if (!course.hasAvailableSeat()){
            result.rejected(RejectionReason.COURSE_FULL);
        } else {
            result.success();
            course.enroll();
        }
        return result;
    } 
}