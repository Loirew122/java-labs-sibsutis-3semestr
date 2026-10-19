package src.task11;

// композиция: цвет добавлен рядом с точкой, а не наследованием; Point остаётся неизменным
public record SafeColoredPoint(SafePoint point, String color) {
}
