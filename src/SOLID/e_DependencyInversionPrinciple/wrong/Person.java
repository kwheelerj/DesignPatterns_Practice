package SOLID.e_DependencyInversionPrinciple.wrong;


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

enum Relationship {
    PARENT, CHILD, SIBLING
}

public class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}


// class to model the relationship between different people
class Relationships {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
    // THIS IS THE PROBLEM:
    // EXPOSING the internal storage implementation of the class with a public getter.
}
/* Relationships is low-level since it is related to data storage.
 *  Notice, there is no business logic.
 * It is, though, correctly following the Single Responsibility Principle, in that
 *  it only manages the relations (in the data structure it has).
 */


class Research {
    public Research(Relationships relationships) {
        /* here, high-level module Research is depending on
         *  low-level module Relationship.
         */
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(
                    x -> x.getValue0().name.equals("John")
                        && x.getValue1() == Relationship.PARENT
                )
                .forEach(
                    x -> System.out.println("John has a child named " + x.getValue2().name)
                );
         /* VIOLATION of the Dependency Inversion Principle!
          * Here, we have the high-level module conducting the search by actually
          *     going into the internal data storage of the Relationships object!
          */
    }
}
/* Research is a high-level module.
 *  Allows operations on the low-level constructs; higher to the end user.
 *  Just gets the end-result(s).
 */

class Demo {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}

/* How to fix this?  Depend on an abstract.
 *  Introduce the abstraction.
 */
