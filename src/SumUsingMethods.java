import java.util.Scanner;

class Algebra{
    int a;
    int b;
    Algebra(int x, int y){
        System.out.println("Constructer of Algebra is called");
        a=x;
        b=y;
    }
    int add(){
        int ans = a+b;
        return ans;
    }
    int sub(){
        int ans = a-b;
        return ans;
    }
    int mul(){
        int ans = a*b;
        return ans;
    }
}

public class SumUsingMethods {
    public static void main(String[] args) {
        Algebra obj = new Algebra(7,4);
        Scanner sc = new Scanner(System.in);
//        int x= sc.nextInt();
 //       int y= sc.nextInt();
       int ans = obj.add();

        System.out.println(ans);
        System.out.println(obj.sub());
        System.out.println(obj.mul());

        Algebra obj2 = new Algebra(59,45);

        System.out.println(obj2.add());
        System.out.println(obj2.sub());
        System.out.println(obj2.mul());

    }
}
