package SOLID.c_LiskovSubstitutionPrinciple;

public class Rectangle {
    protected int width, height;

    public Rectangle() {}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    // for LSP
    public boolean isSquare() {
        return width == height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }
}

class Demo {
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        int height = 10;
        r.setHeight(height);
        int expectedArea = width * height;
        int actualArea = r.getArea();
        System.out.format(
                "Expect area of: %d\n" +
                (expectedArea != actualArea ?
                "FAIL! area is" :
                "Good,  area is") +
                ": %d\n", expectedArea, actualArea);

    }

    public static void main(String[] args) {
        Rectangle r = RectangleFactory.newRectangle(4, 5);
        useIt(r);

        System.out.println();

        Rectangle s = RectangleFactory.newSquare(4);
        s.setWidth(5);
        // LSP - "You should be able to substitute a subclass for a base class."
        useIt(s);
    }
}
