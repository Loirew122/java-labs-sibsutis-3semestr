package src.task14;

// новый формат: добавлен отдельным файлом, существующий код не тронут
public class Webinar implements DeliveryFormat {
    @Override
    public String where() {
        return "вебинар";
    }

    @Override
    public boolean requiresRoom() {
        return false;
    }
}
