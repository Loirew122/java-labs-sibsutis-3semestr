package src.task11;

import java.util.Objects;

public class StrictColoredPoint extends StrictPoint {
    private final String color;

    public StrictColoredPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    // super.equals уже проверил getClass, поэтому здесь тип гарантирован
    @Override
    public boolean equals(Object o) {
        return super.equals(o) && color.equals(((StrictColoredPoint) o).color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }
}
