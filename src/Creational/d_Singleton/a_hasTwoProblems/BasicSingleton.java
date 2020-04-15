package Creational.d_Singleton.a_hasTwoProblems;

import java.io.*;

public class BasicSingleton implements Serializable {

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private BasicSingleton() {}

    private static final
    BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    // called automatically, from Serializable
    protected Object readResolve() {
        return INSTANCE;
    }
}

class Demo {
    public static void main(String[] args) {
//        BasicSingleton bs = new BasicSingleton();
        BasicSingleton bs = BasicSingleton.getInstance();
        System.out.println(bs.getValue());
        System.out.println();
        /* While this does work, and can be used, there are 2 problems
         *  with this singleton design:
         * 1. Reflection - can use it to get to ctor and call it.
         * 2. Serialization - on deserialization, new object still constructed.
         */
        try {
            System.out.println(System.getProperty("java.class.path"));
            String filename =
                "src/Creational/d_Singleton/a_hasTwoProblems/singleton.bin";

            saveToFile(bs, filename);
            bs.setValue(123);

            BasicSingleton bs2 = readFromFile(filename);

            System.out.println(bs == bs2);
            System.out.println(bs.getValue());
            System.out.println(bs2.getValue());
            System.out.println();

            bs.setValue(111);
            bs2.setValue(222);
            System.out.println(bs.getValue());
            System.out.println(bs2.getValue());

            /* Possible to fix this though:
             *  Resolve deserialized object into original object.
             */
            // Object.readResolve method in BasicSingleton class.


        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
            System.err.println(e.getMessage());
        }
    }
    
    static void saveToFile(BasicSingleton singleton, String filename)
            throws IOException {
        // serialize
        try (
            FileOutputStream fileOutput = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOutput)
        ) {
            objOut.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename)
            throws IOException, ClassNotFoundException {
        // deserialize
        try (
            FileInputStream fileInput = new FileInputStream(filename);
            ObjectInputStream objIn = new ObjectInputStream(fileInput);
        ) {
            return (BasicSingleton) objIn.readObject();
        }
    }

}
