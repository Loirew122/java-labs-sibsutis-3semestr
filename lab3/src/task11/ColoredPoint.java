package src.task11;

public class ColoredPoint extends Point {
    private final String color;

    public ColoredPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    // сравнивает ещё и цвет, а Point.equals цвет не знает: отсюда асимметрия
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColoredPoint cp)) return false;
        return super.equals(o) && color.equals(cp.color);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + color.hashCode();
    }
}
