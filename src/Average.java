import java.util.Scanner;

class average {
    public int sum(int a, int b, int c) {
        int ans = a + b + c / 3;
        return ans;
    }
}

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your three numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        average obj = new average();

        System.out.println("Average of numbers is :" + obj.sum(a, b, c));
    }
}
