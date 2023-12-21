import java.util.Scanner;

public class Bitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a|b);
        System.out.println(a&b);
        System.out.println(a^b);
        System.out.println(~a);
        System.out.println(~b);
        System.out.println(a<<b);
        System.out.println(a>>b);
    }
}
