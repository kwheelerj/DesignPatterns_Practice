package Creational.d_Singleton.d_InnerStaticSingleton;

// This singleton supports Thread Safety, w/out synchronized.
public class InnerStaticSingleton {
    private InnerStaticSingleton() {
        System.out.println("InnerStaticSingleton");
    }

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE
                = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}
// Weirdly, this GUARANTEES only one instance exists - thread safety.
