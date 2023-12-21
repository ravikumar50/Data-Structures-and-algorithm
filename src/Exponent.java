import java.util.Scanner;
public class Exponent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number");
        int a = sc.nextInt();

        System.out.println("Enter the second number");
        int b = sc.nextInt();

        int ans=1;

        for(int n=1; n<=b; n++){
            ans*=a;
        }
        System.out.println(ans);
    }
}
