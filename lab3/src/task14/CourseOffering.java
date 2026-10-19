package src.task14;

// один класс на все комбинации: формат и оплата подставляются как компоненты
public class CourseOffering {
    private final String title;
    private final DeliveryFormat format;
    private final PaymentPlan payment;

    public CourseOffering(String title, DeliveryFormat format, PaymentPlan payment) {
        this.title = title;
        this.format = format;
        this.payment = payment;
    }

    public String describe(int months) {
        return title + " | " + format.where()
                + (format.requiresRoom() ? " (нужна аудитория)" : "")
                + " | стоимость за " + months + " мес: " + payment.totalCost(months);
    }
}
