package src.task13;

public class PushChannel implements Channel {
    @Override
    public String notify(String recipient, String message) {
        return "Push to " + recipient + ": " + message.toUpperCase();
    }
}
