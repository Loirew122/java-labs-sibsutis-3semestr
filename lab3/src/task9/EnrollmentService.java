package src.task9;

public class EnrollmentService {
    private final EnrollmentPolicy policy;

    // политика приходит снаружи: сервис знает только интерфейс
    public EnrollmentService(EnrollmentPolicy policy) {
        this.policy = policy;
    }

    public String enroll(Student student, Offer offer) {
        return policy.allows(student, offer)
                ? student.name() + " записан на " + offer.title()
                : student.name() + " отклонён на " + offer.title();
    }
}
