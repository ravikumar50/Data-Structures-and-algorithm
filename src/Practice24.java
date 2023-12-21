import java.util.Scanner;
public class Practice24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int sum=0;
        for(int a=1; a<=(n-2); a++){
            if((n-2)%a==0)
                sum++;
        } if(sum==2)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
