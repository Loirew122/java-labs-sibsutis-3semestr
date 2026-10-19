package src.task2;

public class ConsoleSender extends NotificationSender{
    @Override
    public String  send(String message){
        return "Console: " + message;
    }
}
