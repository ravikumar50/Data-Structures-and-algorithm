import java.util.Scanner;

class Largest {
    public int num(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }
}

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int n = 1; 1 < 2; n++) {
            System.out.println("Enter three numbers");
            int a = sc.nextInt();
            if (a == 0) break;
            int b = sc.nextInt();
            int c = sc.nextInt();


            Largest obj = new Largest();

            System.out.println("Largest number is : " + obj.num(a, b, c));
        }
    }
}