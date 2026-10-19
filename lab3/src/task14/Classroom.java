package src.task14;

public class Classroom implements DeliveryFormat {
    @Override
    public String where() {
        return "аудитория";
    }

    @Override
    public boolean requiresRoom() {
        return true;
    }
}
