import java.util.Scanner;
public class Practice23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a = sc.nextInt();

        for (int i = 1; i * i <= a; i++)
            System.out.println(i * i + ",");
    }
}



