public class LogicalOperators {
    public static void main(String[] args) {
        int a=5, b=7, c=8;

        System.out.println((a < b) && (b < c)); //true
        System.out.println((a>b) || (b>c) || (c>b)); //true
        System.out.println(!(a==b));
    }
}
