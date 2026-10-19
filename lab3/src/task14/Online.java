package src.task14;

public class Online implements DeliveryFormat {
    @Override
    public String where() {
        return "онлайн";
    }

    @Override
    public boolean requiresRoom() {
        return false;
    }
}
