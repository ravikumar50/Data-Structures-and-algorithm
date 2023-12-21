import java.util.Scanner;
public class PrintSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n=sc.nextInt();

        int sum=0;
        int num=1;
        do{
            sum +=num;
            num++;
        } while(num<=n);
        System.out.println(sum);

 //           for(int num=1; num<=n; num++){
 //           sum=sum+num;
        }
//        System.out.println(sum);
    }


