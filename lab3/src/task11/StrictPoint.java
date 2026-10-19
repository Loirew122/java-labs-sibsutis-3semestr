package src.task11;

import java.util.Objects;

// исправление 1: равны только объекты одного и того же класса
public class StrictPoint {
    protected final int x;
    protected final int y;

    public StrictPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StrictPoint p = (StrictPoint) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
