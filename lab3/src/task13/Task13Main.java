package src.task13;

public class Task13Main {
    public static void main(String[] args) {
        String text = "Занятие по Java переносится на пятницу";
        for (String type : new String[]{"email", "sms", "push"}) {
            System.out.println("legacy: " + new LegacyNotifier(type).notify("anna", text));
            System.out.println("new:    " + Channels.byType(type).notify("anna", text));
        }

        // другой отправитель это другой экземпляр, а не новый класс "SupportEmailChannel"
        Channel support = new EmailChannel("support@coursehub");
        System.out.println(support.notify("anna", "ответ на обращение"));
    }
}
