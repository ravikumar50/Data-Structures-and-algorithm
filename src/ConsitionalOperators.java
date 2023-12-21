import java.util.Scanner;
public class ConsitionalOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your number");
        int a = sc.nextInt();

        if(a%3==0 || a%5==0){
            System.out.println("Found ans - "+a);
        } else {
            System.out.println("No ans");
        }
    }
}
