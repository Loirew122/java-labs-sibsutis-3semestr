package src.task4;

public class ConsoleSender extends AbstractNotificationSender{
    @Override
    protected void  doSend(String recipient, String message){
        System.out.println("Console -> " + recipient + " " + message);
    }
}
