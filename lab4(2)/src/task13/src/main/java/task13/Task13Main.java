package task13;

class Task13Main{
    public static void main(String[] args) {
        Course courseClose =  new Course("Java", 2, CourseStatus.CLOSED);
        Course courseOpen =  new Course("Java", 2, CourseStatus.OPEN);
        Course courseFull = new Course("Java", 0, CourseStatus.OPEN);
        EnrollmentRequest requestNonDublicatePrerequisite = new EnrollmentRequest(false, true);
        EnrollmentRequest requestDublicatePrerequisite = new EnrollmentRequest(true, true);
        EnrollmentRequest requestNonDublicateNonPrerequisite =  new EnrollmentRequest(false, false);
        
        //1 course close
        EnrollmentResult result1 = EnrollmentService.enroll(courseClose, requestNonDublicatePrerequisite);
        System.out.println("1 : " + result1.message());
        //2 duplicate true 
        EnrollmentResult result2 = EnrollmentService.enroll(courseOpen, requestDublicatePrerequisite);
        System.out.println("2 : " + result2.message());    
        //3 prerequisite false
        EnrollmentResult result3 = EnrollmentService.enroll(courseOpen, requestNonDublicateNonPrerequisite);
        System.out.println("3 : " + result3.message());    
        //4 course full
        EnrollmentResult result4 = EnrollmentService.enroll(courseFull, requestNonDublicatePrerequisite);
        System.out.println("4 : " + result4.message());  
        //5 success
        EnrollmentResult result5 = EnrollmentService.enroll(courseOpen, requestNonDublicatePrerequisite);
        System.out.println("5 : " + result5.message());  
            
    }
    
}
