package src.task15;

import java.util.Objects;

// наследование уместно здесь: общий каркас и проверка входа, различается только evaluate
public abstract class AbstractRule implements Rule {
    @Override
    public final Verdict check(EnrollmentRequest request) {
        Objects.requireNonNull(request, "request");
        return evaluate(request);
    }

    protected abstract Verdict evaluate(EnrollmentRequest request);
}
