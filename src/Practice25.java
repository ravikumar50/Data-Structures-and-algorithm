import java.util.Scanner;
public class Practice25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Binary Number");
        int b = sc.nextInt();
        System.out.println("Enter the Decimal Number");
        int c = sc.nextInt();
        double sum=0;
        double a=0;
        for(int n=1; b>0; n++){
            sum=sum+((b%10)*Math.pow(2.0,a));
            a++;
            b=b/10;
        }
        System.out.println(sum*c);
    }
}

