package src.task9;

public class CapacityPolicy implements EnrollmentPolicy {
    @Override
    public boolean allows(Student student, Offer offer) {
        return offer.enrolled() < offer.capacity();
    }
}
