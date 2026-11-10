package task15;

final class InfrastructureException extends Exception {
    InfrastructureException(String message) {
        super(message);
    }

    InfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }
}
