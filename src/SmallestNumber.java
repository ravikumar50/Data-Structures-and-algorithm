import java.util.Scanner;

class Number{
    public int num(int a, int b, int c){
        if(a>b && c>b){
            return b;
            }
        else if(b>a && c>a){
            return a;
        }else{
            return c;
        }
    }
}

public class SmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int n = 1; 1 < 2; n++) {
            System.out.println("Enter three numbers");
            int a = sc.nextInt();
            if (a == 0) break;
            int b = sc.nextInt();
            int c = sc.nextInt();


            Number obj = new Number();

            System.out.println("Smallest number is : " + obj.num(a, b, c));
        }
    }
}