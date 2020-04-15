package Creational.d_Singleton.g_Multiton;

import java.util.HashMap;


enum Subsystem {
    PRIMARY, AUXILIARY, FALLBACK
}

// Multiton := key-value store with lazy-loading
public class Printer {
    private static int instanceCount = 0;

    private Printer() {
        instanceCount++;
        System.out.println("A total of " + instanceCount + " created so far.");
    }

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

    public static Printer get(Subsystem ss) {
        // lazy loading, MAX of 3 (each a different type) Printers [Multiton]
        if (instances.containsKey(ss))
            return instances.get(ss);

        Printer instance = new Printer();
        instances.put(ss, instance);
        return instance;
    }
}

class Demo {
    public static void main(String[] args) {
        Printer main = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
    }
}
