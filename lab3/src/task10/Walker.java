package src.task10;

public interface Walker {
    default String move() {
        return "walk";
    }
}
