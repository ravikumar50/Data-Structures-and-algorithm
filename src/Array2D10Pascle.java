import java.util.Scanner;

public class Array2D10Pascle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int r = sc.nextInt();

        int[][] arr = new int[r][];

        for (int i = 0; i < r; i++) {

            arr[i] = new int[i+1];
            arr[i][0] = arr[i][i]=1;

            for (int j = 1; j < i; j++) {// j=1 because 0 already filled and j<i because i+1 alredy filled
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        Print2D obj = new Print2D();
        obj.Array(arr);
    }

}
