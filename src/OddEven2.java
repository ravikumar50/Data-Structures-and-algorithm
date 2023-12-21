import java.util.Scanner;
public class OddEven2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a = sc.nextInt();

        String ans;
        ans = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println(ans);
    }
}