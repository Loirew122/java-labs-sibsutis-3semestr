package src.task15;

public class ScholarshipRule extends AbstractRule {
    @Override
    protected Verdict evaluate(EnrollmentRequest request) {
        return request.applicant().scholarship() ? new Verdict.Allow() : new Verdict.Deny("нет стипендии");
    }
}
