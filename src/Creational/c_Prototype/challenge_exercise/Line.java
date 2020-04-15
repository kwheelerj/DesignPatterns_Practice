package Creational.c_Prototype.challenge_exercise;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line(new Point(start), new Point(end));
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}


class Demo {
    public static void main(String[] args) {
        Line l = new Line(new Point(0, 0), new Point(1, 2));
        Line l2 = l.deepCopy();

        l2.start = new Point(1,1);

        System.out.println(l);
        System.out.println(l2);
    }
}