package src.task15;

public class PrerequisitesRule extends AbstractRule {
    @Override
    protected Verdict evaluate(EnrollmentRequest request) {
        return request.applicant().passedCourses().containsAll(request.offer().prerequisites())
                ? new Verdict.Allow()
                : new Verdict.Deny("не пройдены prerequisites " + request.offer().prerequisites());
    }
}
