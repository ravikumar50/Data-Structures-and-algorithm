package StringBuilder;

import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "Ravi";

        StringBuilder s = new StringBuilder(str);

        s.append(" Kumar".repeat(2));

        System.out.println(s);

        s.delete(4,10);
        System.out.println(s);

        System.out.println(s.indexOf("Kum"));
        System.out.println(s.lastIndexOf("a"));
        s.insert(2,"s");
        System.out.println(s);
        s.deleteCharAt(2);
        System.out.println(s);

        s.replace(2,4,"ramak");
        System.out.println(s);
        s.reverse();
        System.out.println(s);
        s.setCharAt(2,'d');
        System.out.println(s);
        s.append(" ".repeat(4));


        System.out.println(s.length());
        String x = s.toString().trim();
        System.out.println(x.length());

        System.out.println(s.indexOf("skdfl"));



    }
}
