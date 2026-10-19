package src.task15;

public class MinAgeRule extends AbstractRule {
    private final int minAge;

    public MinAgeRule(int minAge) {
        this.minAge = minAge;
    }

    @Override
    protected Verdict evaluate(EnrollmentRequest request) {
        return request.applicant().age() >= minAge
                ? new Verdict.Allow()
                : new Verdict.Deny("возраст меньше " + minAge);
    }
}
