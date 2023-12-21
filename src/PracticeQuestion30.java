public class PracticeQuestion30 {

    static void swap(int a,int b){
        System.out.println("Original value before swap");
        System.out.println("a :"+a);
        System.out.println("b :"+b);

        int x=a;

        a=b;
        b=x;

        System.out.println("Value after swap");
        System.out.println("a :"+a);
        System.out.println("b :"+b);
    }
    public static void main(String[] args) {

        int a = 9;
        int b = 4;

        swap(a,b);
    }
}
