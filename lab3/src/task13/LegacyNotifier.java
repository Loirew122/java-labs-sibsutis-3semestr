package src.task13;

// исходный вариант: поведение выбирается строкой, каждый новый тип правит этот switch
public class LegacyNotifier {
    private final String notificationType;

    public LegacyNotifier(String notificationType) {
        this.notificationType = notificationType;
    }

    public String notify(String recipient, String message) {
        switch (notificationType) {
            case "email":
                return "Email to " + recipient + ": " + message;
            case "sms":
                return "SMS to " + recipient + ": " + message.substring(0, Math.min(message.length(), 20));
            case "push":
                return "Push to " + recipient + ": " + message.toUpperCase();
            default:
                throw new IllegalArgumentException("unknown type " + notificationType);
        }
    }
}
