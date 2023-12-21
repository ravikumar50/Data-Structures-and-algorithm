import java.util.Scanner;

public class guh {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int sum=0;
        int a;
        System.out.println("Enter the number ");
        for(int x=1;x<=8;x++){
            a=sc.nextInt();
            if(a<0){
                break;
            }
            sum=sum+a;
        }
        System.out.println(sum);
          }
}
