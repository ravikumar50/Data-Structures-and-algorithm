import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maths = sc.nextInt();
        int phy = sc.nextInt();
        int chem = sc.nextInt();
        int total = maths+phy+chem;
        int p = (maths+phy+chem)/3;

        System.out.println("Marks in maths is : "+maths);
        System.out.println("Marks in phy is : "+phy);
        System.out.println("Marks in chem is : "+chem);
        System.out.println("Total is : "+total);
        System.out.println("Percentage is : "+p);
    }
}
