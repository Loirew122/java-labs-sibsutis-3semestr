package task15;

final class CourseImportException extends Exception {
    private final ErrorCode errorCode;
    private final int recordNumber;
    private final int processedCount;

    CourseImportException(
            ErrorCode errorCode,
            String message,
            int recordNumber,
            int processedCount,
            Throwable cause
    ) {
        super(message, cause);
        this.errorCode = errorCode;
        this.recordNumber = recordNumber;
        this.processedCount = processedCount;
    }

    ErrorCode errorCode() {
        return errorCode;
    }

    int recordNumber() {
        return recordNumber;
    }

    int processedCount() {
        return processedCount;
    }
}
