package SOLID.e_DependencyInversionPrinciple;


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

enum Relationship {
    PARENT, CHILD, SIBLING
}

public class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

/* This is the abstraction used to follow the DIP */
interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}


class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
            .filter(
                x -> Objects.equals(x.getValue0().name, name)
                    && x.getValue1() == Relationship.PARENT
            )
            .map(Triplet::getValue2)
            .collect(Collectors.toList());
    }
}

class Research {
    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");
        for (Person p : children) {
            System.out.println(p.name);
        }
    }
}

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
