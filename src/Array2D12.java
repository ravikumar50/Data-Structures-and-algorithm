import java.util.Scanner;

public class Array2D12 {

    static void Spiraln(int n) {

        int[][] arr = new int[n][n];

        int toprow = 0;
        int botmrow = n - 1;
        int leftcol = 0;
        int rgtcol = n - 1;

        int a = 1;

        while (a <= n * n){

            for (int j = leftcol; j <= rgtcol && a <= n * n; j++) {
                arr[toprow][j] = a;
                a++;
            }
            toprow++;

            for (int i = toprow; i <= botmrow && a <= n * n; i++) {
                arr[i][rgtcol] = a;
                a++;
            }
            rgtcol--;

            for (int j = rgtcol; j >= leftcol && a <= n * n; j--) {
                arr[botmrow][j] = a;
                a++;
            }
            botmrow--;

            for (int i = botmrow; i >= toprow && a < n * n; i--) {
                arr[i][leftcol] = a;
                a++;
            }
            leftcol++;
        }
        Print2D obj = new Print2D();
        obj.Array(arr);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n = sc.nextInt();

        Spiraln(n);
    }
}
