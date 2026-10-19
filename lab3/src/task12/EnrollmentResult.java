package src.task12;

// sealed: список наследников закрыт и известен компилятору
public sealed interface EnrollmentResult
        permits EnrollmentResult.Accepted, EnrollmentResult.Rejected,
        EnrollmentResult.WaitListed, EnrollmentResult.Postponed {

    record Accepted(String student) implements EnrollmentResult {
    }

    record Rejected(String student, String reason) implements EnrollmentResult {
    }

    record WaitListed(String student, int position) implements EnrollmentResult {
    }

    // добавлен последним для проверки: что потребует изменений
    record Postponed(String student, String until) implements EnrollmentResult {
    }
}
