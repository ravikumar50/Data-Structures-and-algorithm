import java.util.Scanner;
public class HSDALKH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age");
        int a = sc.nextInt();

        String age;
        age = (a < 18) ? "Teenage" : "Adult" ;
        System.out.println(age);
    }
}
