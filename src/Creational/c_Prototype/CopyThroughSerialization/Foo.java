package Creational.c_Prototype.CopyThroughSerialization;

import java.io.Serializable;
import org.apache.commons.lang3.SerializationUtils;

public class Foo implements Serializable {
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}


class Demo {
    public static void main(String[] args) {
        Foo f = new Foo(42, "life");

        // This will serialize the object, then deserialize it,
        //  which creates a new copy.
        Foo f2 = SerializationUtils.roundtrip(f);
        f2.whatever = "xyz";

        System.out.println(f);
        System.out.println(f2);
    }
}
