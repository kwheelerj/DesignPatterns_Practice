package Creational.b_Factory.FactoryMethod;


public class Point {
    private double x, y;

    private Point(double a, double b) {
        this.x = a;
        this.y = b;
    }

    public static Point newCartesian(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolar(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
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
        Point cp = Point.newCartesian(1, 3);
        System.out.println(cp);

        Point pp = Point.newPolar(4, Math.PI / 3);
        System.out.println(pp);
    }
}