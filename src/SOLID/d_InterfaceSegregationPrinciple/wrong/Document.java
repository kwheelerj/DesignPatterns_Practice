package SOLID.d_InterfaceSegregationPrinciple.wrong;


// Say you are just writing a class and an interface for the client to implement
public class Document {

}

interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}


// client would have to do this
class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}
// BUT, what if the client wants a simple printer
// that is, they don't need every method in the interface implemented
class SimplePrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {
        // throw new Exception("N/A");
        /* Can't throw exception, since that would have
         *  to propagate back up to interface.
         */
    }

    @Override
    public void scan(Document d) {

    }
}
