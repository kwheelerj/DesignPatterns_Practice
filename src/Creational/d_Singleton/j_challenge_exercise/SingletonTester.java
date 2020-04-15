package Creational.d_Singleton.j_challenge_exercise;

import java.util.function.Supplier;

public class SingletonTester {
    public static boolean isSingleton(Supplier<Object> func) {
        return func.get() == func.get();
    }
}

class Demo {
    public static void main(String[] args) {
        Supplier<Object> f3 = InnerStaticSingleton::getInstance;
        boolean res2 = SingletonTester.isSingleton(f3);
        System.out.println(res2);

    }
}

class InnerStaticSingleton {
    private InnerStaticSingleton() {
        System.out.println("InnerStaticSingleton");
    }

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE
                = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}