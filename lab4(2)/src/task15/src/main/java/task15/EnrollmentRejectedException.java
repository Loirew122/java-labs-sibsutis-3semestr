package task15;

final class EnrollmentRejectedException extends Exception {
    private final ErrorCode errorCode;

    EnrollmentRejectedException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    ErrorCode errorCode() {
        return errorCode;
    }
}
