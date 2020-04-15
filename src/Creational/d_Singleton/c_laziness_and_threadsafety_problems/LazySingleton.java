package Creational.d_Singleton.c_laziness_and_threadsafety_problems;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing LazySingleton...");
    }

    public static LazySingleton getInstance() {
        // to be lazy; notice ctor not called until here.
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
        /* HOWEVER, this introduces potential race issue, if threads */
    }

    // a solution to thread safety (performance hit, though):
    public static synchronized LazySingleton getInstanceSync() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // other techniques exist;
    // here is "double-checked locking" [outdated, though]:
    public static LazySingleton getInstanceDCL() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
