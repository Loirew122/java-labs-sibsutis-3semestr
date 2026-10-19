package src.task15;

import java.util.Set;

public class BlacklistRule extends AbstractRule {
    private final Set<String> banned;

    public BlacklistRule(Set<String> banned) {
        this.banned = banned;
    }

    @Override
    protected Verdict evaluate(EnrollmentRequest request) {
        return banned.contains(request.applicant().name())
                ? new Verdict.Deny("в чёрном списке")
                : new Verdict.Allow();
    }
}
