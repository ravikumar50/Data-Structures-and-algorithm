import java.util.Scanner;
public class FindingNumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n= sc.nextInt();

        int a=0;

        while(n>0){
            n=n/10;
            a++;
        }
        System.out.println("number of digits in the given number is: "+a);
    }
}
