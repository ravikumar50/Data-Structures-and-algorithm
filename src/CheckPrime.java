import java.util.Scanner;
public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n= sc.nextInt();
        int a=0;
        for(int num=1; num<=n; num++){
           if(n%num==0){
               a++;
               }
           }

        if(a==2) {
            System.out.println("Prime Number");
        } else{
            System.out.println("Not Prime Number");
        }
    }
}
