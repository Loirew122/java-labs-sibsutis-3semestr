package src.task15;

// закрытая иерархия результата: все варианты известны компилятору
public sealed interface Verdict permits Verdict.Allow, Verdict.Deny, Verdict.WaitList {

    record Allow() implements Verdict {
    }

    record Deny(String reason) implements Verdict {
    }

    record WaitList(int position) implements Verdict {
    }
}
