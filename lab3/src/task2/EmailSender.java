package src.task2;

public class EmailSender extends NotificationSender {
    @Override
    public String send(String message){
        return "Email: " + message;
    }
}
