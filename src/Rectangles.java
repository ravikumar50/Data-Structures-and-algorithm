import java.util.Scanner;

public class Rectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length and breadth of rectangle");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int perimeter = 2*(a+b);
        int area = a*b;

        System.out.println("Perimeter of Rectanngle is "+perimeter);
        System.out.println("Area of Rectangle is "+area);
    }
}
