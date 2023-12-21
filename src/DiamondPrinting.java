import java.util.Scanner;
public class DiamondPrinting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int r = sc.nextInt();
//        System.out.println("Enter the number of column");
//        int c = sc.nextInt();
        int alpha =65;
        int num=0;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= r - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print((char)(alpha+num++));
            }
            num=0;
            System.out.println();
        }
        for (int x=1; x<=r; x++){
            for(int y=1; y<=x; y++){
                System.out.print(" ");
            } for(int z=1; z<=2*(r-x)-1; z++){
                System.out.print((char)(alpha+num++));
            }
            num=0;
            System.out.println();
        }
    }
}
