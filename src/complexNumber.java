import java.util.Scanner;

public class complexNumber {

    static void Add(int a1, int b1, int a2, int b2){
        int a = a1+a2;
        int b = b1+b2;

        System.out.println("Addition of these two numbers is "+a+"+ ("+b+"i)");
    }

    static void Sub(int a1, int b1, int a2, int b2){
        int a = a1-a2;
        int b = b1-b2;
        System.out.println("Subtraction of these two numbers is "+a+" + ("+b+"i)");

    }

    static void Multiply(int a1, int b1, int a2, int b2){
        int a = a1*a2 - b1*b2;
        int b = a1*b2 + a2*b1;

        System.out.println("Multiplication of these two numbers is "+a+" + ("+b+"i)");
    }



    static void Division(int a1, int b1, int a2, int b2){

        int a = a1*a2 + b1*b2;
        int b = b1*a2 - a1*b2;

        int deno = a2*a2+b2*b2;

        System.out.println("Division of these two numbers is ("+a+" + ("+b+"i))/"+deno);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the real part of First number");
        int a1 = sc.nextInt();
        System.out.println("Enter the imaginary part of First number");
        int b1 = sc.nextInt();

        System.out.println("Enter thr real part of Second number");
        int a2 = sc.nextInt();
        System.out.println("Enter the imaginary part of Second number");
        int b2 = sc.nextInt();

        System.out.println("First Number is "+a1+" + "+b1+"i");
        System.out.println("Second Number is "+a2+" + "+b2+"i");

        Add(a1,b1,a2,b2);
        Sub(a1,b1,a2,b2);
        Multiply(a1,b1,a2,b2);
        Division(a1,b1,a2,b2);
    }
}
