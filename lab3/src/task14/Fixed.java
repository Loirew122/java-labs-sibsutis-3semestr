package src.task14;

public class Fixed implements PaymentPlan {
    private final int price;

    public Fixed(int price) {
        this.price = price;
    }

    @Override
    public int totalCost(int months) {
        return price;
    }
}
