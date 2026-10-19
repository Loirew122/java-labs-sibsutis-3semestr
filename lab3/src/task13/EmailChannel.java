package src.task13;

public class EmailChannel implements Channel {
    // отправитель это данные, а не поведение: разные адреса дают разные объекты, а не подклассы
    private final String from;

    public EmailChannel(String from) {
        this.from = from;
    }

    @Override
    public String notify(String recipient, String message) {
        return "Email from " + from + " to " + recipient + ": " + message;
    }
}
