package src.task7;

// исходный вариант с наследованием: логирование жёстко привязано к EmailSender
// retry и metrics придётся добавлять новыми подклассами (RetryLoggingEmailSender и т. д.)
public class LoggingEmailSender extends EmailSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("    log: send to " + recipient);
        super.send(recipient, message);
    }
}
