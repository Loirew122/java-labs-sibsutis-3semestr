package src.task4;


// abstract: объект этого класса создать нельзя, он только база для наследников
public abstract class AbstractNotificationSender implements  NotificationSender{
    @Override
    public final void send(String recipient, String message){
        if (recipient == null || recipient.isBlank())
            // throw бросает исключение: метод прерывается, а вызывающий код получает ошибку
            throw  new IllegalArgumentException("Error");
        doSend(recipient.trim(), message);
    }

    // abstract: тела нет, каждый наследник обязан реализовать метод сам
    protected  abstract void doSend(String recipient, String message);
}
