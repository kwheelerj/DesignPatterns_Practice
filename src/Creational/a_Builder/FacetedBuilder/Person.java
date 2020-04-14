package Creational.a_Builder.FacetedBuilder;

/* Combination of Builder pattern and Facade pattern. */

public class Person {
    public String streetAddress, zipcode, city;

    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

class PersonBuilder {
    protected Person person = new Person();

    // this will return a brand new builder!
    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    // this will return a brand new builder!
    public PersonEmployerBuilder works() {
        return new PersonEmployerBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withZipCode(String zipcode) {
        person.zipcode = zipcode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }
}

class PersonEmployerBuilder extends PersonBuilder {

    public PersonEmployerBuilder(Person person) {
        this.person = person;
    }

    public PersonEmployerBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonEmployerBuilder as(String position) {
        person.position = position;
        return this;
    }

    public PersonEmployerBuilder making(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }
}

/* why did both PersonAddressBuilder and PersonEmployerBuilder extend
 *  PersonBuilder?
 * Now both inherit the lives() and works() methods, so one can
 *  switch back and forth between the sub-builders inside the
 *  single fluent api call.
 */

class Demo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person p = pb
                .lives()
                    .at("123 Main Street").in("Metrocity").withZipCode("12345")
                .works().at("A Company").as("Software Developer").making(110000)
                .build();

        System.out.println(p);
    }
}
