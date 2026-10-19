package src.task11;

// исправление 2: record неявно final, equals/hashCode генерируются по компонентам
public record SafePoint(int x, int y) {
}
