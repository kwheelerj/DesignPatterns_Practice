package Creational.b_Factory.AbstractFactory;

public interface HotDrink {
    void consume();
}
class Tea implements HotDrink {
    public String type;

    public Tea(String type) {
        this.type = type;
    }

    @Override
    public void consume() {
        System.out.println("This " + type + " tea is delicious.");
    }
}
class Coffee implements HotDrink {
    public String type;

    public Coffee(String type) {
        this.type = type;
    }

    @Override
    public void consume() {
        System.out.println("This " + type + " coffee is delicious.");
    }
}
/* We can have a correspondence of hierarchy to construct the objects. */
interface HotDrinkFactory {
    HotDrink prepare(int amount, String type);
}
class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount, String type) {
        System.out.println("Preparation:\n\tBoil water\n\tPut tea bag in cup\n"
        + "\tPour " + amount + "ml of boiled water into cup\n"
        + "\tSteep for 3 min\n\tEnjoy!");
        return new Tea(type);
    }
}
class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount, String type) {
        System.out.println("Preparation:\n\tGrind " + amount / 10 + "g of beans\n"
                + "\tPut beans in french press\n"
                + "\tPour " + amount + "ml of boiled water into french press\n"
                + "\tLet sit for 4 minutes\n\tPress slowly\n\tDecanter\n\tEnjoy!");
        return new Coffee(type);
    }
}

class Demo {
    public static void main(String[] args) throws Exception {
        HotDrink tea = new TeaFactory().prepare(200, "green");
        tea.consume();
        HotDrink coffee = new CoffeeFactory().prepare(600, "black, medium roast");
        coffee.consume();
    }
}
