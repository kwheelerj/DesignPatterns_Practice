package Creational.d_Singleton.e_EnumBasedSingleton;

import java.io.*;

enum EnumBasedSingleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    EnumBasedSingleton() {
        value = 42;
    }
}

class Demo {
    public static void main(String[] args) throws Exception {
        String filename =
                "src/Creational/d_Singleton/e_EnumBasedSingleton/myfile.bin";

//        EnumBasedSingleton es = EnumBasedSingleton.INSTANCE;
//        System.out.println(es.getValue());
//        System.out.println();
//        es.setValue(111);
//        saveToFile(es, filename);

        EnumBasedSingleton es2 = readFromFile(filename);
        System.out.println(es2.getValue());
    }

    static void saveToFile(EnumBasedSingleton singleton, String filename)
            throws IOException {
        // serialize
        try (
                FileOutputStream fileOutput = new FileOutputStream(filename);
                ObjectOutputStream objOut = new ObjectOutputStream(fileOutput)
        ) {
            objOut.writeObject(singleton);
        }
    }

    static EnumBasedSingleton readFromFile(String filename)
            throws IOException, ClassNotFoundException {
        // deserialize
        try (
                FileInputStream fileInput = new FileInputStream(filename);
                ObjectInputStream objIn = new ObjectInputStream(fileInput);
        ) {
            return (EnumBasedSingleton) objIn.readObject();
        }
    }

}



