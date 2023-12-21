import java.util.Scanner;

public class Array2D2 {

    static void Add(int[][] arr1, int[][] arr2, int r1, int r2 , int c1, int c2) {

        if (r1 != r2 || c1 != c2) {
            System.out.println("Invalid Input");
        }
        else {
            int[][] ans = new int[r1][c2];

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    ans[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            Print2D obj3 = new Print2D();
            obj3.Array(ans);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the number of rows of 1st array");
        int r1 = sc.nextInt();

        System.out.println("Enter the number of column of 1st array");
        int c1 = sc.nextInt();

        int[][] arr1 = new int[r1][c1];

        for (int i = 0; i < r1; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < c1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of rows of 2st array");
        int r2 = sc.nextInt();

        System.out.println("Enter the number of column of 2nd array");
        int c2 = sc.nextInt();

        int[][] arr2 = new int[r1][c1];

        for (int i = 0; i < r1; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < c1; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        Add(arr1,arr2,r1,r2,c1,c2);
    }
}
