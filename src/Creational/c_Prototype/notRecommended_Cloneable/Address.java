package Creational.c_Prototype.notRecommended_Cloneable;

import java.util.Arrays;

public class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // valid, but naive, deep copy
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable {
    public String[] names;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // the following is fundamentally incorrect - references
//        return new Person(names, address);
        return new Person(names.clone(), (Address) address.clone());
    }

    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
}

class Demo {
    public static void main(String[] args) throws Exception {
        Person john = new Person(
                new String[]{"John", "Smith"},
                new Address("Main Street", 123)
        );
        System.out.println(john);
        System.out.println();

        Person jane = (Person) john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;
        System.out.println(jane);
        System.out.println(john);
    }
}