import java.util.Scanner;

public class Array2D9 {

    static void Rotation(int[][] arr, int r, int c) {

        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = arr[r-1-j][i];
            }
        }
        Print2D obj = new Print2D();
        obj.Array(ans);
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
//        Rotation(arr,r1,c1);

        Transpose obj = new Transpose();
        int[][] arr1 = obj.Array(arr,r1,c1);

        Revrese2D obj2 =new Revrese2D();
        int[][] ans = obj2.Array(arr1,r1,c1);

        Print2D obj3 = new Print2D();
        obj3.Array(ans);
    }

}
