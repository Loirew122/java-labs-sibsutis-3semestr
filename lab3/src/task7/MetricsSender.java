package src.task7;

public class MetricsSender implements NotificationSender {
    private final NotificationSender delegate;
    private final String name;
    private int calls;
    private int failures;

    public MetricsSender(NotificationSender delegate, String name) {
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public void send(String recipient, String message) {
        calls++;
        try {
            delegate.send(recipient, message);
        } catch (RuntimeException e) {
            failures++;
            throw e;
        }
    }

    public String report() {
        return name + ": calls=" + calls + ", failures=" + failures;
    }
}
