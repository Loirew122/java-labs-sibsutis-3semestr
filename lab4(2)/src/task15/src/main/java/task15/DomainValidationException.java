package task15;

final class DomainValidationException extends IllegalArgumentException {
    DomainValidationException(String message) {
        super(message);
    }
}
