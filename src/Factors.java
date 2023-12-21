import java.util.Scanner;
public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int num = sc.nextInt();

        for(int n=1; n<=num; n++){
            if(num%n==0){
                System.out.print(n+ " ");
            }
        }
    }
}
