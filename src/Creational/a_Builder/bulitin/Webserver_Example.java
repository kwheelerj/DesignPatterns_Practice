package Creational.a_Builder.bulitin;

public class Webserver_Example {
    // serve a webpage, alot of html tags to concat together
    public static void main(String[] args) {
        String[] words = {"hello", "world"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word : words)
            sb.append(String.format("    <li>%s</li>\n", word));
        sb.append("</ul>");
        System.out.println(sb.toString());
    }

}
