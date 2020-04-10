package SOLID.b_OpenClosedPrinciple;


import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

public class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}


@FunctionalInterface
interface Specification<T> {
    boolean isSatisfied(T item);
}

@FunctionalInterface
interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}


class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class ProductFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(spec::isSatisfied);
    }
}


// If want to combine two specifications, need to write a Combinator
class AndSpecification<T> implements Specification<T> {
    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}


class Demo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products: ");
        pf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        System.out.println("Large, green products: ");
        pf.filter(products,
                new AndSpecification<Product>(
                        new ColorSpecification(Color.GREEN),
                        new SizeSpecification(Size.LARGE)
                )
        ).forEach(p -> System.out.println(" - " + p.name + " is large and green."));

        System.out.println("Large, blue products: ");
        pf.filter(products,
                new AndSpecification<>(
                        new SizeSpecification(Size.LARGE),
                        p -> p.color == Color.BLUE
                )
        ).forEach(p -> System.out.println(" - " + p.name + " is large and blue."));

    }
}
