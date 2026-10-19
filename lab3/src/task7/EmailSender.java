package src.task7;

public class EmailSender implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("    Email -> " + recipient + ": " + message);
    }
}
