import java.util.Scanner;
public class PatternPrinting4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int r = sc.nextInt();
        System.out.println("Enter the number of column");
        int c = sc.nextInt();

        for(int i=1; i<=r; i++){
            for(int j=1; j<=(r+1-i); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
