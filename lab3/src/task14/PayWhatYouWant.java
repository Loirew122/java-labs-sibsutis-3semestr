package src.task14;

// новая оплата: тоже отдельный файл
public class PayWhatYouWant implements PaymentPlan {
    private final int donation;

    public PayWhatYouWant(int donation) {
        this.donation = donation;
    }

    @Override
    public int totalCost(int months) {
        return donation;
    }
}
