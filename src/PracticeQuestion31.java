public class PracticeQuestion31 {
    static void swap(int a , int b){

        System.out.println("Original value before swap");
        System.out.println("a : "+a);
        System.out.println("b : "+b);

        a=a+b;
        b=a-b;
        a=a-b;

        System.out.println("Value after swap");
        System.out.println("a : "+a);
        System.out.println("b : "+b);
    }

    public static void main(String[] args) {

        int a=9;
        int b=6;

        swap(a,b);
    }
}
