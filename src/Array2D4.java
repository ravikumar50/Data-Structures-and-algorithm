import java.util.Scanner;

class Revrese2D{
    public int[][] Array(int[][] arr, int r, int c){
        for (int n = 0; n < r; n++) {
            int i = 0;
            int j = c - 1;
            int a = 0;

            while (i <= j) {
                a = arr[n][i];
                arr[n][i] = arr[n][j];
                arr[n][j] = a;
                i++;
                j--;
            }
        }
        return arr;
    }
}

public class Array2D4 {

    static void Reverse(int[][] arr, int r1, int c1) {


        Print2D obj = new Print2D();
        obj.Array(arr);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the number of rows of 1st array");
        int r1 = sc.nextInt();

        System.out.println("Enter the number of column of 1st array");
        int c1 = sc.nextInt();

        int[][] arr = new int[r1][c1];

        for (int i = 0; i < r1; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < c1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Reverse(arr, r1, c1);
    }
}

