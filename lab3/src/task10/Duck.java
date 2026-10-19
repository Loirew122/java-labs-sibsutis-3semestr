package src.task10;

public class Duck implements Walker, Swimmer {
    // конфликт default-методов компилятор сам не разрешает: нужен явный override
    @Override
    public String move() {
        // Интерфейс.super.метод() вызывает default конкретного интерфейса
        return Walker.super.move() + " + " + Swimmer.super.move();
    }
}
