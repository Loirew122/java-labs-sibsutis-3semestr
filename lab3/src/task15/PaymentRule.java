package src.task15;

public class PaymentRule extends AbstractRule {
    @Override
    protected Verdict evaluate(EnrollmentRequest request) {
        return request.applicant().paid() ? new Verdict.Allow() : new Verdict.Deny("нет оплаты");
    }
}
