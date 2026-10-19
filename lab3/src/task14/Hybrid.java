package src.task14;

public class Hybrid implements DeliveryFormat {
    @Override
    public String where() {
        return "аудитория + онлайн";
    }

    @Override
    public boolean requiresRoom() {
        return true;
    }
}
