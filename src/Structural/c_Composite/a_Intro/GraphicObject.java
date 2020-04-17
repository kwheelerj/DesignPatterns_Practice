package Structural.c_Composite.a_Intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicObject {
    protected String name = "Group";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GraphicObject() {
    }

    public String color;

    public List<GraphicObject> children = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }

    private void print(StringBuilder stringBuilder, int depth) {
        stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
                .append(depth > 0 ? " " : "")
                .append( (color == null || color.isEmpty()) ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());
        for (GraphicObject child : children) {
            child.print(stringBuilder, depth+1);
        }
    }
}

class Circle extends GraphicObject {
    public Circle(String color) {
        name = "circle";
        this.color = color;
    }
}

class Square extends GraphicObject {
    public Square(String color) {
        name = "square";
        this.color = color;
    }
}

class Demo {
    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("my drawing");
        drawing.children.add(new Square("red"));
        drawing.children.add(new Circle("yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("blue"));
        group.children.add(new Square("blue"));
        drawing.children.add(group);

        System.out.println(drawing);
    }
}