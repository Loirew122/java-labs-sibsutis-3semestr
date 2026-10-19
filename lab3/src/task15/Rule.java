package src.task15;

// открытая иерархия: правила может добавлять любой код, движок о них не знает
public interface Rule {
    Verdict check(EnrollmentRequest request);
}
