package task15;

import java.io.StringReader;

class Task15Main {
    public static void main(String[] args) {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        CourseHubFacade courseHub = new CourseHubFacade(repository);

        String validCourses = "JAVA101;Java Basics;100;OPEN;1\n"
                + "DB200;Databases;80;OPEN;8";
        OperationResult<Integer> importResult = courseHub.importCourses(
                new StringReader(validCourses)
        );

        System.out.println("1 - Successful import");
        System.out.println("Success: " + importResult.successful());
        System.out.println("Processed: " + importResult.value());
        System.out.println("Repository size: " + repository.size());

        OperationResult<Integer> malformedResult = courseHub.importCourses(
                new StringReader("SPRING300;Spring;60;OPEN;5\nBROKEN")
        );

        System.out.println();
        System.out.println("2 - Malformed import");
        System.out.println("Success: " + malformedResult.successful());
        System.out.println("Code: " + malformedResult.errorCode());
        System.out.println(
                "Cause: " + malformedResult.cause().getCause()
        );
        System.out.println("Repository size: " + repository.size());

        OperationResult<Course> enrollmentResult = courseHub.enroll(
                " java101 ",
                new EnrollmentRequest("student-1", false, true)
        );

        System.out.println();
        System.out.println("3 - Successful enrollment");
        System.out.println("Success: " + enrollmentResult.successful());
        System.out.println(
                "Enrolled count: "
                        + enrollmentResult.value().enrolledCount()
        );

        OperationResult<Course> rejectionResult = courseHub.enroll(
                "JAVA101",
                new EnrollmentRequest("student-2", false, true)
        );

        System.out.println();
        System.out.println("4 - Expected rejection");
        System.out.println("Success: " + rejectionResult.successful());
        System.out.println("Code: " + rejectionResult.errorCode());
        System.out.println("Message: " + rejectionResult.message());
    }
}
