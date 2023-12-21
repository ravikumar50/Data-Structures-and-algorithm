import java.util.Scanner;
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double x= (-b+ Math.sqrt(b*b-4*a*c))/2*a;
        double y= (-b- Math.sqrt(b*b-4*a*c))/2*a;
        System.out.println(x+","+y);


    }
}
