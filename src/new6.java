import java.util.Scanner;
public class new6 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        int a = Integer.valueOf(args[0]);
        int b = Integer.valueOf(args[1]);
        int c = Integer.valueOf(args[2]);

        System.out.println("The given equation is "+a+"x^2+"+b+"x+"+c);

        double d = b*b-4*a*c;
        if(d<0){
            System.out.println("Roots are imaginary");
            return;
        }else if(d==0){
            System.out.println("Both roots are equal");
            double x = (-b*1.0)/(2*a);
            System.out.println("Roots is "+x);
        }else{
            double k = Math.sqrt(d);
            double x1 = (-b+k)/2*a;
            double x2 = (-b-k)/2*a;
            System.out.println("First root is "+x1);
            System.out.println("Second root is "+x2);
        }
    }
}

