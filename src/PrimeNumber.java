import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number");
        int a = sc.nextInt();

        for (int n = 2; n <= a; n++) {
            int p = 0;
            for (int j = 1; j <= n; j++) {
                if (n % j == 0)
                    p++;
            }
            if (p == 2)
                System.out.println(n + ",");
        }
    }
}

