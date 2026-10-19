package src.task2;

public class NotificationSender {
    public String send (String message){
        return "base: " + message;
    }

    // Перегрузка (overload): то же имя, другой тип параметра. Это НОВАЯ сигнатура, а не переопределение.
    public String send(Object message) {
        return "base(Object): " + message;
    }
}
