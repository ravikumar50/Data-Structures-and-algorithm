import java.util.Scanner;
public class Suminfinite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");

        int sum=0;

        for(int n=0; n<=1000; n++){
            int a = sc.nextInt();
        sum=sum+a;
        if(a==0)break;
        }
        System.out.println(sum);
    }
}
