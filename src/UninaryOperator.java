public class UninaryOperator {
    public static void main(String[] args) {
        int p=7, q=5;

        System.out.println(p++); //7  p=8
        System.out.println(p);  //8

        System.out.println(++q); //6  q=6
        System.out.println(q);  //6

        int x= ++p;
        int y= q++;

        System.out.println(x);  //9  p=9
        System.out.println(y);  //6 q=7
        System.out.println(p);  //9
        System.out.println(q);  //7
    }
}
