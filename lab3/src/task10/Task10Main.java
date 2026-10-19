package src.task10;

public class Task10Main {
    public static void main(String[] args) {
        Duck duck = new Duck();
        System.out.println(duck.move());

        // через ссылку интерфейсного типа вызывается тот же override Duck
        Walker walker = duck;
        System.out.println(walker.move());
    }
}
