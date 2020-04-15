package Creational.d_Singleton.b_StaticBlockSingleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {
    private int value = 0;

    public int getValue() {
        return value;
    }

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing.");
        File.createTempFile("123", ".");
    }
    // Notice, this ctor can throw an exception.
    // This situation is where static block singletons come in handy.

    private static StaticBlockSingleton instance;    // notice not final

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (IOException e) {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

class Demo {
    public static void main(String[] args) {
        StaticBlockSingleton sbs = StaticBlockSingleton.getInstance();
        System.out.println(sbs.getValue());
        System.out.println();
    }
}
