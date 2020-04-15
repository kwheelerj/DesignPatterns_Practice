package Creational.d_Singleton.f_Monostate;

public class ChiefExecutiveOfficer {
    // to make a normal instance class a singleton, have members as static
    private static String name;
    private static int age;
    // can many as many instances of CEO as want, BUT all data members
    // are just shared to one set.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Demo {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Adam Smith");
        ceo.setAge(45);

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();

        System.out.println(ceo);
        System.out.println(ceo2);
    }
}
