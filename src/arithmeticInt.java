import java.util.Scanner;

public class arithmeticInt{
public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a :");
        float a = sc.nextFloat();

        System.out.println("Enter b :");
        float b = sc.nextFloat();

        float sum = a+b;
        float sub = a-b;
        float mul = a*b;
        float div = a/b;

        System.out.println("Sum is "+sum);
        System.out.println("Sub is "+sub);
        System.out.println("Mul is "+mul);
        System.out.println("Div is "+div);
        }
        }

