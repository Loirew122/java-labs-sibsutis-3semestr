package src.task15;

import java.util.ArrayList;
import java.util.List;

public class AnyOf implements Rule {
    private final List<Rule> rules;

    public AnyOf(Rule... rules) {
        this.rules = List.of(rules);
    }

    // первый Allow обрывает проверку; иначе WaitList, а если его нет, то Deny со всеми причинами
    @Override
    public Verdict check(EnrollmentRequest request) {
        Verdict waiting = null;
        List<String> reasons = new ArrayList<>();
        for (Rule rule : rules) {
            Verdict verdict = rule.check(request);
            switch (verdict) {
                case Verdict.Allow a -> {
                    return a;
                }
                case Verdict.WaitList w -> {
                    if (waiting == null) waiting = w;
                }
                case Verdict.Deny d -> reasons.add(d.reason());
            }
        }
        if (waiting != null) return waiting;
        return new Verdict.Deny(reasons.isEmpty() ? "нет правил" : String.join(" и ", reasons));
    }
}
