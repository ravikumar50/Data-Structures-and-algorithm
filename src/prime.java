import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();


        if(n==0){
            System.out.println("Factorial of "+n+" is 1");
            return;
        }
        int ans = 1;

        for(int i=1; i<=n; i++){
            ans=ans*i;
        }

        System.out.println("Factorial of "+n+" is "+ans);
    }
}
