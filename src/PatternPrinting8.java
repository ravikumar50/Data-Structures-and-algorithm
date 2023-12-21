import java.util.Scanner;
public class PatternPrinting8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int r = sc.nextInt();
        System.out.println("Enter the number of column");
        int c = sc.nextInt();

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i == 1 || i == r)
                    System.out.print(j);
                else if (j == 1)
                    System.out.print("1");
                else if (j == c)
                    System.out.print(c);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
