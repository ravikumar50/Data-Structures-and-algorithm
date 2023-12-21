import java.util.Scanner;
public class primefactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number");
        int a = sc.nextInt();

        for(int n=1;n<=a; n++){
            if(a%n==0)
            System.out.println(n);
        }
    }
}