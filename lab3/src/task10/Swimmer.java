package src.task10;

public interface Swimmer {
    default String move() {
        return "swim";
    }
}
