import java.util.Scanner;
public class Practice20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a = sc.nextInt();
        int b=0;
        for(int n=0; n<=4; n++){
           int c= a%10;

           b+=c;
           a/=10;


        }
        System.out.println(b);
    }
}
