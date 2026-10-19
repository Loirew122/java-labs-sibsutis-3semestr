package src.task6;

public class Task6Main {
    public static void main(String[] args) {
        Report fixed = new FixedReport();
        System.out.println(fixed.render(3));
        fixed.print("hello");
        System.out.println(fixed.info());

        // без @Override всё компилируется, но метод потомка не вызывается
        Report loose = new LooseReport();
        System.out.println(loose.render(3));

        // метод потомка достижим только через ссылку его типа и аргумент Integer
        LooseReport looseRef = new LooseReport();
        System.out.println(looseRef.render(Integer.valueOf(3)));
    }
}
