package src.task9;

public class PrerequisitePolicy implements EnrollmentPolicy {
    @Override
    public boolean allows(Student student, Offer offer) {
        return student.passedCourses().containsAll(offer.prerequisites());
    }
}
