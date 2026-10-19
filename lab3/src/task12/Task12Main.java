package src.task12;

import src.task12.EnrollmentResult.Accepted;
import src.task12.EnrollmentResult.Postponed;
import src.task12.EnrollmentResult.Rejected;
import src.task12.EnrollmentResult.WaitListed;

import java.util.List;

public class Task12Main {
    // switch-выражение по sealed-типу без default: компилятор проверяет, что покрыты все варианты
    static String describe(EnrollmentResult result) {
        return switch (result) {
            case Accepted a -> a.student() + " принят";
            case Rejected r -> r.student() + " отклонён: " + r.reason();
            case WaitListed w -> w.student() + " в очереди, место " + w.position();
            case Postponed p -> p.student() + " отложен до " + p.until();
        };
    }

    public static void main(String[] args) {
        List<EnrollmentResult> results = List.of(
                new Accepted("Anna"),
                new Rejected("Boris", "мал возраст"),
                new WaitListed("Clara", 3),
                new Postponed("Dmitry", "следующего семестра"));
        for (EnrollmentResult r : results) {
            System.out.println(describe(r));
        }
    }
}
