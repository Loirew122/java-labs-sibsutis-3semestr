package src.task7;

// тестовый отправитель: первые failures вызовов падают, дальше работает
public class FlakySender implements NotificationSender {
    private int failuresLeft;

    public FlakySender(int failures) {
        this.failuresLeft = failures;
    }

    @Override
    public void send(String recipient, String message) {
        if (failuresLeft > 0) {
            failuresLeft--;
            throw new IllegalStateException("temporary failure");
        }
        System.out.println("    delivered to " + recipient + ": " + message);
    }
}
