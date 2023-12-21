import java.util.Scanner;

public class Area {
    int a,b,c;
    public double Triangle(int a, int b, int c){
     double p=a+b+c;
     double s=p/2.0;
     double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
     return area;
    }
    public double Circle(int a){
        double area = 3.14*a*a;
        return area;
    }
    public double Rectangle(int a, int b){
        double area = a*b;
        return area;
    }
    public double Square(int a){
        double area = a*a;
        return area;
    }
}

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which area do you want?");
        System.out.println("1.Triangle   2.Circle    3.Rectangle    4.Square");
        int ch = sc.nextInt();

        if (ch == 1) {
            System.out.println("Enter all the three sides");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Area obj = new Area();

            System.out.println(obj.Triangle(a, b, c));
        } else if (ch == 2) {
            System.out.println("Enter the Radius");
            int a = sc.nextInt();

            Area obj = new Area();

            System.out.println(obj.Circle(a));
        } else if (ch == 3) {
            System.out.println("Enter the length and breadth");
            int a = sc.nextInt();
            int b = sc.nextInt();

            Area obj = new Area();

            System.out.println(obj.Rectangle(a, b));
        } else if (ch == 4) {
            System.out.println("Enter the side of Square");
            int a = sc.nextInt();

            Area obj = new Area();
            System.out.println(obj.Square(a));
        } else {
            System.out.println("Invalid Request");
        }
    }
}
