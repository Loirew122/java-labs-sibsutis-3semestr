package task13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class EnrollmentTest{
    @Test
    void enroll_courseClosed_CourseStatusClosed(){
        Course courseClose =  new Course("Java", 2, CourseStatus.CLOSED);
        EnrollmentRequest requestNonDublicatePrerequisite = new EnrollmentRequest(false, true);
        int before = courseClose.enrolledCount();
        EnrollmentResult result = EnrollmentService.enroll(courseClose, requestNonDublicatePrerequisite);
        RejectionReason reason = RejectionReason.COURSE_CLOSED;
        assertEquals(reason, result.reason());
        assertEquals(before, courseClose.enrolledCount());
    }
    @Test
    void enroll_alreadyEnrolled_requestDuplicateTrue(){
        Course courseOpen =  new Course("Java", 2, CourseStatus.OPEN);
        EnrollmentRequest requestDublicatePrerequisite = new EnrollmentRequest(true, true);
        int before = courseOpen.enrolledCount();
        EnrollmentResult result = EnrollmentService.enroll(courseOpen, requestDublicatePrerequisite);
        RejectionReason reason = RejectionReason.ALREADY_ENROLLED;
        assertEquals(reason, result.reason());
        assertEquals(before, courseOpen.enrolledCount());
    }
    @Test
    void enroll_prerequisite_missing_requestPrerequisiteCompletedFalse(){
        Course courseOpen =  new Course("Java", 2, CourseStatus.OPEN);
        EnrollmentRequest requestNonDublicateNonPrerequisite =  new EnrollmentRequest(false, false);
        int before = courseOpen.enrolledCount();
        EnrollmentResult result = EnrollmentService.enroll(courseOpen, requestNonDublicateNonPrerequisite);
        RejectionReason reason = RejectionReason.PREREQUISITE_MISSING;
        assertEquals(reason, result.reason());
        assertEquals(before, courseOpen.enrolledCount());
    }
    @Test
    void enroll_courseFull_courseCapacityFull(){
        Course courseFull = new Course("Java", 1, CourseStatus.OPEN);
        courseFull.enroll();
        EnrollmentRequest requestNonDublicatePrerequisite = new EnrollmentRequest(false, true);
        int before = courseFull.enrolledCount();
        EnrollmentResult result = EnrollmentService.enroll(courseFull, requestNonDublicatePrerequisite);
        RejectionReason reason = RejectionReason.COURSE_FULL;
        assertEquals(reason, result.reason());
        assertEquals(before, courseFull.enrolledCount());
        
    }
    @Test
    void enroll_success(){
        Course courseOpen =  new Course("Java", 2, CourseStatus.OPEN);
        EnrollmentRequest requestNonDublicatePrerequisite = new EnrollmentRequest(false, true);
        int before = courseOpen.enrolledCount();
        EnrollmentResult result = EnrollmentService.enroll(courseOpen, requestNonDublicatePrerequisite);
        boolean successful = true;
        assertEquals(successful, result.successful());
        assertEquals(before+1, courseOpen.enrolledCount());
    }
}
