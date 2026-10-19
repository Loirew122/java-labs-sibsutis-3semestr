package src.task13;

public class SmsChannel implements Channel {
    private final int maxLength;

    public SmsChannel(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String notify(String recipient, String message) {
        return "SMS to " + recipient + ": " + message.substring(0, Math.min(message.length(), maxLength));
    }
}
