import java.util.Scanner;
public class Practice12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int num = sc.nextInt();

        if (num<=0) {
            System.out.println(num*(-1));
        } else {
            System.out.println(num);
        }
    }
}
