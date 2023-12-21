import java.util.Scanner;
public class SumOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int num= sc.nextInt();
        int ans=0;
        for(int n=1; n<=num; n++){
            if (n%2==0){
                ans-=n;
            } else{
                ans+=n;
            }
        }
        System.out.println(ans);
    }
}
