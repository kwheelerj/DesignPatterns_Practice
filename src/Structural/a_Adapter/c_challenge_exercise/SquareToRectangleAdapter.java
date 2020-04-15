package Structural.a_Adapter.c_challenge_exercise;

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

public class SquareToRectangleAdapter implements Rectangle
{
    private int side;

    public SquareToRectangleAdapter(Square square)
    {
        side = square.side;
    }

    @Override
    public int getWidth() {
        return side;
    }

    @Override
    public int getHeight() {
        return side;
    }
}

class Demo {
    public static void main(String[] args) {
        Square square = new Square(4);
        SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(square);
        System.out.println(adapter.getHeight());
        System.out.println(adapter.getWidth());
    }
}