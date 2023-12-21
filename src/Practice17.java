import java.util.Scanner;
public class Practice17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n=sc.nextInt();

        int sum=0;

        for(int num=1; num<=n; num++){
            sum=sum+(num*num);
        }
        System.out.println(sum);
    }
}
