package src.task15;

public class CapacityRule extends AbstractRule {
    @Override
    protected Verdict evaluate(EnrollmentRequest request) {
        Offer offer = request.offer();
        if (offer.enrolled() < offer.capacity()) return new Verdict.Allow();
        // мест нет: это не отказ, а очередь
        return new Verdict.WaitList(offer.enrolled() - offer.capacity() + 1);
    }
}
