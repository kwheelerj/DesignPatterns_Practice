package Structural.c_Composite.c_challenge_exercise;

import java.util.*;
import java.util.function.Consumer;


public interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}


class MyList extends ArrayList<ValueContainer> {
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int total = 0;
        for (ValueContainer vc : this) {
            for (Integer i : vc) {
                total += i;
            }
        }
        return total;
    }
}

class Demo {
    public static void main(String[] args) {
        MyList myList = new MyList(List.of(new SingleValue(1), new SingleValue(3)));
        System.out.println(myList.sum());
        System.out.println();

        ManyValues mv = new ManyValues();
        mv.add(4);
        mv.add(5);

        System.out.println(
            new MyList(List.of(
                new SingleValue(4),
                mv
            )).sum()
        );

    }
}
