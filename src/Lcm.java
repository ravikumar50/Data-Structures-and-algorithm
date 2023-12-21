import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans=0;
        for(int i=a; i<=a*b; i++){
            if(i%a==0 && i%b==0){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

}
