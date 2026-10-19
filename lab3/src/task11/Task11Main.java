package src.task11;

public class Task11Main {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColoredPoint cp = new ColoredPoint(1, 2, "red");
        System.out.println("нарушение симметрии:");
        System.out.println("  p.equals(cp)  = " + p.equals(cp));
        System.out.println("  cp.equals(p)  = " + cp.equals(p));

        StrictPoint sp = new StrictPoint(1, 2);
        StrictColoredPoint scp = new StrictColoredPoint(1, 2, "red");
        System.out.println("strict class equality:");
        System.out.println("  sp.equals(scp)  = " + sp.equals(scp));
        System.out.println("  scp.equals(sp)  = " + scp.equals(sp));

        // анонимный подкласс без новых полей тоже не равен базовому: подтип нельзя подставить вместо типа
        StrictPoint anonymous = new StrictPoint(1, 2) { };
        System.out.println("  sp.equals(anonymous)  = " + sp.equals(anonymous));

        SafePoint a = new SafePoint(1, 2);
        SafeColoredPoint ac = new SafeColoredPoint(a, "red");
        System.out.println("композиция:");
        System.out.println("  a.equals(ac)  = " + a.equals(ac));
        System.out.println("  ac.equals(a)  = " + ac.equals(a));
        System.out.println("  ac.equals(new SafeColoredPoint(new SafePoint(1, 2), \"red\"))  = "
                + ac.equals(new SafeColoredPoint(new SafePoint(1, 2), "red")));
    }
}
