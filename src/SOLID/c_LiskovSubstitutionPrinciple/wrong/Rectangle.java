package SOLID.c_LiskovSubstitutionPrinciple.wrong;

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

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class Square extends Rectangle {
    public Square() {}

    public Square(int size) {
        width = height = size;
    }

    // special overrides to set the width and height
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
    // HOWEVER, this violates the "Liskov Substitution Principle"
    // See how in Demo.main
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
        Rectangle r = new Rectangle(4, 5);
        useIt(r);

        System.out.println();

        Rectangle s = new Square(4);
        s.setWidth(5);
        // LSP - "You should be able to substitute a subclass for a base class."
        useIt(s);
    }
}
