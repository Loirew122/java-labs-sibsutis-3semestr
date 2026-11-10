package task15;

import java.util.Objects;

final class OperationResult<T> {
    private final boolean successful;
    private final T value;
    private final ErrorCode errorCode;
    private final String message;
    private final Throwable cause;

    private OperationResult(
            boolean successful,
            T value,
            ErrorCode errorCode,
            String message,
            Throwable cause
    ) {
        this.successful = successful;
        this.value = value;
        this.errorCode = errorCode;
        this.message = Objects.requireNonNull(message);
        this.cause = cause;
    }

    static <T> OperationResult<T> success(T value) {
        return new OperationResult<>(true, value, null, "Success", null);
    }

    static <T> OperationResult<T> failure(
            ErrorCode errorCode,
            String message,
            Throwable cause
    ) {
        return new OperationResult<>(
                false,
                null,
                Objects.requireNonNull(errorCode),
                message,
                Objects.requireNonNull(cause)
        );
    }

    boolean successful() {
        return successful;
    }

    T value() {
        return value;
    }

    ErrorCode errorCode() {
        return errorCode;
    }

    String message() {
        return message;
    }

    Throwable cause() {
        return cause;
    }
}
