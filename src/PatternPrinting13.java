import java.util.Scanner;
public class PatternPrinting13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n = sc.nextInt();

        int a = 1;
        int b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " , ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }
}


