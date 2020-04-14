package Creational.a_Builder.FluentBuilderInheritance_withRecursiveGenerics.wrong;

/* Builders can inherit from other builders.
 *  BUT, you may lose the fluent interface, like so:
 */
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

class PersonBuilder {
    protected Person person = new Person();

    public PersonBuilder withName(String name) {
        person.name = name;
        return this;
    }

    public Person build() {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return this;
    }   // this looks ok, but there is a problem.
}

class Demo {
    public static void main(String[] args) {
        PersonBuilder pbuilder = new PersonBuilder();
        Person kenneth = pbuilder.withName("Kenneth").build();
        System.out.println(kenneth);

        EmployeeBuilder ebuilder = new EmployeeBuilder();
        Person ken = ebuilder.withName("Ken")
//                .worksAt("company")   // THIS DOES NOT WORK!
                .build();
        /* Why? because withName() returns "this" - PersonBuilder. */

        /* Solution?  Java recursive generics on the PersonBuilder! */

    }
}
