import java.util.Scanner;
public class ReverseTheDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n= sc.nextInt();
        int ans=0;
        int x=n;

        while(n>0){
           ans=ans*10+n%10;
           n=n/10;
        }
        if(ans==x){
            System.out.println("yes");
        }else{
            System.out.println("No");
        }
    }
}
