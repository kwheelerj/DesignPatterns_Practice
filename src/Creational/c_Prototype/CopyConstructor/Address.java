package Creational.c_Prototype.CopyConstructor;

public class Address {
    public String streetAddress, city, country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    // copy constructor
    public Address(Address other) {
        this(other.streetAddress, other.city, other.country);
    }
}

class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    // copy constructor
    public Employee(Employee other) {
        this(other.name, new Address(other.address));
    }
}


class Demo {
    public static void main(String[] args) {
        Employee john = new Employee(
            "John",
            new Address("123 Main Street", "Metrocity", "USA")
        );
        Employee chris = new Employee(john);    // use Employee copy ctor
        chris.name = "Chris";

        System.out.println(john);
        System.out.println(chris);
    }
}
