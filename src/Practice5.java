import java.util.Scanner;
public class Practice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a= sc.nextInt();

        System.out.println((((a+8)/3)%5)*5);
    }
}
