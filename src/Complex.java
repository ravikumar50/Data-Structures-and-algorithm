import java.util.Scanner;

public class Complex {

    public int sum1(int a, int c) {

        int x = a + c;
        return x;

    }

    public int sub1(int a, int c) {
        int x = a - c;
        return x;
    }

    public int mult1(int a, int b, int c, int d) {
        int x = a * c;
        int y = b * d;
        int ans = x - y;
        return ans;
    }

    public int mult2(int a, int b, int c, int d) {
        int x = a * c;
        int y = b * d;
        int ans = x + y;
        return ans;
    }
}

    class Result {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the real part of first number");
            int a = sc.nextInt();
            System.out.println("Enter the imaginary part of first number");
            int b = sc.nextInt();
            System.out.println("Enter the real part of second number");
            int c = sc.nextByte();
            System.out.println("Enter the imaginary part of second number");
            int d = sc.nextInt();

            Complex obj1 = new Complex();


            System.out.println("The result of sum is: " + obj1.sum1(a, c) + "+" + obj1.sum1(b, d) + "i");

            System.out.println("The result of sub is: " + obj1.sub1(a, c) + "+" + obj1.sub1(b, d) + "i");

            System.out.println("The result of mult is :" + obj1.mult1(a, b, c, d) + "+" + obj1.mult2(a, b, d, c)+"i");
        }
    }
