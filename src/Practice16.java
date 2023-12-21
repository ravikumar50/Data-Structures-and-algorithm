import java.util.Scanner;
public class Practice16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n= sc.nextInt();

        for(int num=n; num>=1; num--){
            System.out.println(num);
        }

    }
}
