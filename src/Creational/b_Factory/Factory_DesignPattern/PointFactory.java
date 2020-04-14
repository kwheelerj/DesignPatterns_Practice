package Creational.b_Factory.Factory_DesignPattern;


class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static class Factory {
        public static Point newCartesian(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolar(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}

class Demo {
    public static void main(String[] args) {
        Point cp = Point.Factory.newCartesian(1, 3);
        System.out.println(cp);

        Point pp = Point.Factory.newPolar(4, Math.PI / 3);
        System.out.println(pp);
    }
}
