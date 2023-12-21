import java.util.Scanner;
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a = sc.nextInt();
        int tens = 1;
        int ans = 0;
        while(a>0) {
            ans = ans + a % 2 * tens;
            a = a / 2;
            tens *= 10;
        }
        System.out.println(ans);
    }
}
