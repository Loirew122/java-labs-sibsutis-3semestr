package src.task14;

public class Subscription implements PaymentPlan {
    private final int monthly;

    public Subscription(int monthly) {
        this.monthly = monthly;
    }

    @Override
    public int totalCost(int months) {
        return monthly * months;
    }
}
