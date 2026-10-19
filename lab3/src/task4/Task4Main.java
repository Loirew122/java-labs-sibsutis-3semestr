package src.task4;

public class    Task4Main {
    public static void main(String[] args){
        NotificationSender[] senders = {new EmailSender(), new ConsoleSender()};
        senders[0].send("   example    ", "hello");
        senders[1].send("   example    ", "hello");

        try {
            senders[0].send(null, "hello");

        } catch (IllegalArgumentException error){
            System.out.println("recipient must not be blank\n" + error.getMessage());
        }
    }
}
