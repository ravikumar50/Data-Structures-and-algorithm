import java.util.Scanner;

public class avg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers");

        double sum=0;
        double p=0;

        for(int n=1; 1<2; n++){
            int a = sc.nextInt();
            if(a==0)break;
            sum=sum+a;
            p++;
        }
        System.out.println(sum/p);
    }
}
