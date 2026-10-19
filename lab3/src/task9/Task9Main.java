package src.task9;

import java.util.Set;

public class Task9Main {
    public static void main(String[] args) {
        Offer spring = new Offer("Spring", Set.of("Java"), 2, 1);
        Student anna = new Student("Anna", 20, Set.of("Java"));
        Student boris = new Student("Boris", 16, Set.of());

        EnrollmentPolicy[] policies = {new AgePolicy(18), new PrerequisitePolicy(), new CapacityPolicy()};
        for (EnrollmentPolicy policy : policies) {
            EnrollmentService service = new EnrollmentService(policy);
            System.out.println(policy.getClass().getSimpleName() + ":");
            System.out.println("  " + service.enroll(anna, spring));
            System.out.println("  " + service.enroll(boris, spring));
        }

        // новая политика (лямбда, т. к. интерфейс с одним методом): EnrollmentService не менялся
        EnrollmentPolicy noBoris = (student, offer) -> !student.name().equals("Boris");
        EnrollmentService custom = new EnrollmentService(noBoris);
        System.out.println("новая политика:");
        System.out.println("  " + custom.enroll(anna, spring));
        System.out.println("  " + custom.enroll(boris, spring));
    }
}
