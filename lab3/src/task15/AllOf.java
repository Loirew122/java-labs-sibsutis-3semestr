package src.task15;

import java.util.List;

// композиция: сам является Rule, поэтому вкладывается в другие AllOf/AnyOf
public class AllOf implements Rule {
    private final List<Rule> rules;

    public AllOf(Rule... rules) {
        this.rules = List.of(rules);
    }

    // первый Deny обрывает проверку; WaitList запоминается и возвращается, если Deny не было
    @Override
    public Verdict check(EnrollmentRequest request) {
        Verdict waiting = null;
        for (Rule rule : rules) {
            Verdict verdict = rule.check(request);
            if (verdict instanceof Verdict.Deny) return verdict;
            if (verdict instanceof Verdict.WaitList && waiting == null) waiting = verdict;
        }
        return waiting != null ? waiting : new Verdict.Allow();
    }
}
