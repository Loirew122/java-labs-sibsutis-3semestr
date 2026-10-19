package src.task15;

public class EnrollmentEngine {
    private final Rule rule;

    public EnrollmentEngine(Rule rule) {
        this.rule = rule;
    }

    // сервис видит только Rule и Verdict: ни одного конкретного класса правила
    public String enroll(EnrollmentRequest request) {
        String who = request.applicant().name();
        return switch (rule.check(request)) {
            case Verdict.Allow a -> who + ": принят";
            case Verdict.Deny d -> who + ": отказ, " + d.reason();
            case Verdict.WaitList w -> who + ": очередь, место " + w.position();
        };
    }
}
