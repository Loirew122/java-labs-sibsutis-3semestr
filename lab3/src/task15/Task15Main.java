package src.task15;

import java.util.Set;

public class Task15Main {
    public static void main(String[] args) {
        Offer open = new Offer("Spring", Set.of("Java"), 2, 1);
        Offer full = new Offer("Spring", Set.of("Java"), 1, 1);

        Applicant anna = new Applicant("Anna", 20, Set.of("Java"), true, false);
        Applicant boris = new Applicant("Boris", 16, Set.of("Java"), true, false);
        Applicant clara = new Applicant("Clara", 21, Set.of("Java"), false, true);
        Applicant dmitry = new Applicant("Dmitry", 22, Set.of(), true, false);
        Applicant egor = new Applicant("Egor", 23, Set.of("Java"), false, false);
        Applicant fedor = new Applicant("Fedor", 25, Set.of("Java"), true, false);

        Rule policy = new AllOf(
                new BlacklistRule(Set.of("Fedor")),
                new MinAgeRule(18),
                new PrerequisitesRule(),
                new AnyOf(new PaymentRule(), new ScholarshipRule()),
                new CapacityRule());
        EnrollmentEngine engine = new EnrollmentEngine(policy);

        System.out.println("--- есть места ---");
        for (Applicant a : new Applicant[]{anna, boris, clara, dmitry, egor, fedor}) {
            System.out.println(engine.enroll(new EnrollmentRequest(a, open)));
        }
        System.out.println("--- мест нет ---");
        System.out.println(engine.enroll(new EnrollmentRequest(anna, full)));

        // dynamic dispatch: ссылки одного типа Rule, метод выбирается по классу объекта
        System.out.println("--- dynamic dispatch для Egor ---");
        Rule[] rules = {new MinAgeRule(18), new PaymentRule(), new ScholarshipRule(), new CapacityRule(),
                new AnyOf(new PaymentRule(), new ScholarshipRule()), policy};
        for (Rule r : rules) {
            System.out.println(r.getClass().getSimpleName() + " -> " + r.check(new EnrollmentRequest(egor, open)));
        }
    }
}
