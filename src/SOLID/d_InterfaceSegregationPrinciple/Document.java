package SOLID.d_InterfaceSegregationPrinciple;


public class Document {

}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}


class SimplePrinter implements Printer {
    @Override
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}


interface MultiFunctionDevice extends Printer, Scanner {}


class MultiFunctioneMachine implements MultiFunctionDevice {
    // Could use a Decorator pattern here, like so:
    private Printer printer;
    private Scanner scanner;

    public MultiFunctioneMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}