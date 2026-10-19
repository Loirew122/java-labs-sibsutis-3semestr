package src.task15;

import java.util.Set;

public record Applicant(String name, int age, Set<String> passedCourses, boolean paid, boolean scholarship) {
}
