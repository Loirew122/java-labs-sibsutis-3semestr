package task15;

import java.util.Objects;

final class EnrollmentService {
    void enroll(Course course, EnrollmentRequest request)
            throws EnrollmentRejectedException {
        Objects.requireNonNull(course);
        Objects.requireNonNull(request);

        if (course.status() != CourseStatus.OPEN) {
            reject(ErrorCode.COURSE_NOT_OPEN, "Course is not open");
        }
        if (request.duplicate()) {
            reject(ErrorCode.ALREADY_ENROLLED, "Student is already enrolled");
        }
        if (!request.prerequisiteCompleted()) {
            reject(
                    ErrorCode.PREREQUISITE_MISSING,
                    "Required prerequisite is missing"
            );
        }
        if (!course.hasAvailableSeat()) {
            reject(ErrorCode.COURSE_FULL, "Course is full");
        }

        course.enroll();
    }

    private void reject(ErrorCode errorCode, String message)
            throws EnrollmentRejectedException {
        throw new EnrollmentRejectedException(errorCode, message);
    }
}
