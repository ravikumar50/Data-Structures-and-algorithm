import java.util.Scanner;
public class PatternPrinting5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int r = sc.nextInt();
        System.out.println("Enter the number of column");
        int c = sc.nextInt();

        for (int i = 1; i <= r; i++) {
            for ( int j=1; j<=r-i; j++){
                System.out.print(" ");
            } for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
