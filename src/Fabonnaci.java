import java.util.Scanner;

public class Fabonnaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter how many numbers you want");
        int n=sc.nextInt();

        int x=0;
        int y=1;
        int a=x+y;

        System.out.println(x);
        System.out.println(y);

        for(int i=2; i<=n; i++){
            x=y;
            y=a;
            a=x+y;
            System.out.println(a);
        }
    }
}
