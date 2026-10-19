package src.task4;

public class EmailSender  extends  AbstractNotificationSender{
    @Override
    protected void  doSend(String recipient, String message){
        System.out.println("Email -> " + recipient + " " + message);
    }
}
