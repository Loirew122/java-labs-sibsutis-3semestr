package src.task7;

public class RetrySender implements NotificationSender {
    private final NotificationSender delegate;
    private final int attempts;

    public RetrySender(NotificationSender delegate, int attempts) {
        this.delegate = delegate;
        this.attempts = attempts;
    }

    @Override
    public void send(String recipient, String message) {
        RuntimeException last = null;
        for (int i = 1; i <= attempts; i++) {
            try {
                delegate.send(recipient, message);
                return;
            } catch (RuntimeException e) {
                last = e;
            }
        }
        throw last;
    }
}
