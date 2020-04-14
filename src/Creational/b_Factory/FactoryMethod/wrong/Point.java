package Creational.b_Factory.FactoryMethod.wrong;


enum CoordinateSystem {
    CARTESIAN, POLAR
}

public class Point {
    private double x, y;

    /**
     * COMPLICATED BUILDER, forces necessity of good documentation;
     *  otherwise, there will be confusion.
     *
     * @param a is x if CARTESIAN or rho if POLAR
     * @param b is y if CARTESIAN or theta if POLAR
     * @param cs is either CoordinateSystem.CARTESIAN or CoordinateSystem.POLAR
     */
    public Point(double a, double b, CoordinateSystem cs) {
        if (cs == CoordinateSystem.CARTESIAN) {
            this.x = a;
            this.y = b;
        } else if (cs == CoordinateSystem.POLAR) {
            x = a * Math.cos(b);
            y = a * Math.sin(b);
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Demo {
    public static void main(String[] args) {
        Point cp = new Point(1, 3, CoordinateSystem.CARTESIAN);
        System.out.println(cp);

        Point pp = new Point(4, Math.PI / 3, CoordinateSystem.POLAR);
        System.out.println(pp);
    }
}