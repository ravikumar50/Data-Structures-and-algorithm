public class Practice {
    public static void main(String[] args) {

        int x=5;
        int y=6;
        int z=9;
        System.out.println("before swap x is : "+x);
        System.out.println("before swap y is : "+y);
        System.out.println("before swao z is : "+z);
        int c; //variable used to swap three numbers
        c=x;
        x=y;
        y=z;
        z=c;
        System.out.println("after swap x is : "+x);
        System.out.println("after swap y is : "+y);
        System.out.println("after swap z is : "+z);
    }
}
