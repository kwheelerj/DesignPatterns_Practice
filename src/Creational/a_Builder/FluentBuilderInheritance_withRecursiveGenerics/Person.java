package Creational.a_Builder.FluentBuilderInheritance_withRecursiveGenerics;

public class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<T extends PersonBuilder<T>> {
    protected Person person = new Person();

    public T withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    public T self() {
        return (T) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }
}

class Demo {
    public static void main(String[] args) {
        PersonBuilder pbuilder = new PersonBuilder();
        Person kenneth = pbuilder.withName("Kenneth").build();
        System.out.println(kenneth);

        EmployeeBuilder ebuilder = new EmployeeBuilder();
        Person ken = ebuilder.withName("Ken")
                .worksAt("company")
                .build();
        System.out.println(ken);

    }
}
