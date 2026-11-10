package task15;

record EnrollmentRequest(
        String studentId,
        boolean duplicate,
        boolean prerequisiteCompleted
) {
    EnrollmentRequest {
        if (studentId == null || studentId.isBlank()) {
            throw new DomainValidationException("Student ID is required");
        }
        studentId = studentId.strip();
    }
}
