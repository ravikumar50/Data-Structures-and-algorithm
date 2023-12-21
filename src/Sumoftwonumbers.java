import java.util.Scanner;

public class Sumoftwonumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("first number");
        int a = sc.nextInt();

        System.out.println("second number");
        int b = sc.nextInt();

        int sum = a+b;
        System.out.println("sum is: "+sum);

    }
}
