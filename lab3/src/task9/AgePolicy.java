package src.task9;

public class AgePolicy implements EnrollmentPolicy {
    private final int minAge;

    public AgePolicy(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean allows(Student student, Offer offer) {
        return student.age() >= minAge;
    }
}
