package src.task2;

public class Task2Main {
    public static void main(String[] args) {
        NotificationSender a = new EmailSender();
        NotificationSender b = new ConsoleSender();

        EmailSender c = new EmailSender();
        ConsoleSender d = new ConsoleSender();
        System.out.println(a.send("hi"));
        System.out.println(b.send("hi"));
        System.out.println(c.send("hi"));
        System.out.println(d.send("hi"));
        NotificationSender e = new NotificationSender();
        System.out.println(e.send("hi"));

        // --- Шаг 4: перегрузка против переопределения ---
        Object o = "hi";   // статический тип Object, динамический (внутри) - String

        // Компилятор по статическому типу аргумента (String) выбирает send(String);
        // JVM по классу объекта в a (EmailSender) вызывает его реализацию -> "Email: hi"
        System.out.println(a.send("hi"));

        // Компилятор по статическому типу аргумента (Object) выбирает send(Object);
        // EmailSender его не переопределял -> выполняется базовый -> "base(Object): hi"
        System.out.println(a.send(o));

        // Тот же аргумент o, но объект другой: ConsoleSender тоже не переопределял send(Object)
        System.out.println(b.send(o));

    }
}
