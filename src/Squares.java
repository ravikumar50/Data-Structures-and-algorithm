import java.util.Scanner;

public class Squares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sides of Square");
        int a = sc.nextInt();

        int area = a*a;
        int perimeter = 4*a;

        System.out.println("Perimeter of Square is "+perimeter);
        System.out.println("Area of Square is "+area);
    }
}
