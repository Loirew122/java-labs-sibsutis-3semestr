package src.task7;

public class Task7Main {
    public static void main(String[] args) {
        System.out.println("--- logging внутри retry: Retry(Logging(Flaky)) ---");
        NotificationSender a = new RetrySender(new LoggingSender(new FlakySender(2), "log"), 3);
        a.send("anna", "hi");

        System.out.println("--- logging снаружи retry: Logging(Retry(Flaky)) ---");
        NotificationSender b = new LoggingSender(new RetrySender(new FlakySender(2), 3), "log");
        b.send("anna", "hi");

        System.out.println("--- metrics внутри retry: Retry(Metrics(Flaky)) ---");
        MetricsSender inner = new MetricsSender(new FlakySender(2), "inner");
        new RetrySender(inner, 3).send("anna", "hi");
        System.out.println("    " + inner.report());

        System.out.println("--- metrics снаружи retry: Metrics(Retry(Flaky)) ---");
        MetricsSender outer = new MetricsSender(new RetrySender(new FlakySender(2), 3), "outer");
        outer.send("anna", "hi");
        System.out.println("    " + outer.report());
    }
}
