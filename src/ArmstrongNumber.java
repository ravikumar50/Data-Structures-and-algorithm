import java.util.Scanner;
public class ArmstrongNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a = sc.nextInt();

        for (int n = 1; n <= a; n++) {
            int sum = 0;
            int m=n;
            for(int k=1; m>0; k++){
                int r=m%10;
                sum=sum+(r*r*r);
                m=m/10;


                }
            if (sum == n){
                System.out.println(sum);
            }
        }
    }
}
