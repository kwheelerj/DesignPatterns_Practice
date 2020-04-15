package Structural.b_Bridge.b_challenge_exercise;

// FOR BRIDGE
interface Renderer {
    String whatToRenderAs();
}
class VectorRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}
class RasterRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}
// End of FOR BRIDGE
abstract class Shape
{
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract String getName();

    @Override
    public String toString() {
//        return renderer.toString();
        return "Drawing " + getName() + " as " + renderer.whatToRenderAs();
    }
}

class Triangle extends Shape
{
    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }
}

class Square extends Shape
{
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }
}

class VectorSquare extends Square
{
    public VectorSquare(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString()
    {
        return String.format("Drawing %s as lines", getName());
    }

}

class RasterSquare extends Square
{
    public RasterSquare(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString()
    {
        return String.format("Drawing %s as pixels", getName());
    }
}

// imagine VectorTriangle and RasterTriangle are here too

class Demo {
    public static void main(String[] args) {
        System.out.println(new Triangle(new RasterRenderer()));
        // should return "Drawing Triangle as pixels"
    }
}