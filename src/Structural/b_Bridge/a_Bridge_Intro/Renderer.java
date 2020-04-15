package Structural.b_Bridge.a_Bridge_Intro;

interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radiius " + radius);
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius " + radius);
    }
}

abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Shape {

    public float radius;

    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

class Demo {
    public static void main(String[] args) {
        RasterRenderer raster = new RasterRenderer();
        VectorRenderer vector = new VectorRenderer();
        Circle circle = new Circle(vector, 5);
        circle.draw();
        circle.resize(2);
        circle.draw();

        // this approach must have renderer manually inserted
        // want a single renderer supplied for every object being constructed
        // use dependency injection framework
    }
}
