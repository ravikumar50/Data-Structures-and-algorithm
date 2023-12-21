import java.util.Scanner;
public class Practice9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a= sc.nextInt();

        if (a%2==0 && a%3==0) {
            System.out.println("Found ans : "+a);
        } else {
            System.out.println("No ans");
        }
    }
}
