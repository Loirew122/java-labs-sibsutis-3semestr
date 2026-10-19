package src.task14;

public class Task14Main {
    public static void main(String[] args) {
        DeliveryFormat[] formats = {new Online(), new Classroom(), new Hybrid()};
        PaymentPlan[] plans = {new Free(), new Fixed(5000), new Subscription(900)};

        // 3 формата x 3 оплаты = 9 комбинаций из 6 небольших классов и одного CourseOffering
        for (DeliveryFormat f : formats) {
            for (PaymentPlan p : plans) {
                System.out.println(new CourseOffering("Java", f, p).describe(3));
            }
        }

        System.out.println("--- новые варианты ---");
        System.out.println(new CourseOffering("Java", new Webinar(), new Subscription(900)).describe(3));
        System.out.println(new CourseOffering("Java", new Online(), new PayWhatYouWant(300)).describe(3));
        System.out.println(new CourseOffering("Java", new Webinar(), new PayWhatYouWant(300)).describe(3));
    }
}
