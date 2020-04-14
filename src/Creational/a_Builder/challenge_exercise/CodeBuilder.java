package Creational.a_Builder.challenge_exercise;

import java.util.ArrayList;

public class CodeBuilder
{
    String className;
    ArrayList<Member> members = new ArrayList<>();

    public CodeBuilder(String className)
    {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        Member m = new Member(name, type);
        members.add(m);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(this.className).append("\n{\n");
        for (Member member : members) {
            sb.append(member.toString());
            sb.append("\n");
        }
        sb.append("}");

        return sb.toString();
    }
}

class Member {
    private String type;
    private String name;

    public Member(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("  public %s %s;", this.type, this.name);
    }
}
/* Expected output:
public class Person
{
    public String name;
    public int age;
}
 */
class Demo {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}