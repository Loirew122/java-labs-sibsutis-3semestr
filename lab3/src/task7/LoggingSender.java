package src.task7;

// декоратор: реализует тот же интерфейс и оборачивает другой NotificationSender
public class LoggingSender implements NotificationSender {
    private final NotificationSender delegate;
    private final String name;

    public LoggingSender(NotificationSender delegate, String name) {
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("    [" + name + "] before send to " + recipient);
        try {
            delegate.send(recipient, message);
            System.out.println("    [" + name + "] ok");
        } catch (RuntimeException e) {
            System.out.println("    [" + name + "] failed: " + e.getMessage());
            throw e;
        }
    }
}
