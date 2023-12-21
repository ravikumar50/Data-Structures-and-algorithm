import java.util.Scanner;

public class Array2D7 {

    static void Array1Dto2D(int[] arr, int a, int b) {

        int x = arr.length;

        int k = 0;

        int[][] ans = new int[a][b];

        if (a * b == x) {
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    ans[i][j] = arr[k];
                    k++;
                }
            }
        } else {
            System.out.println("New 2D Array cannot be formed");
            return;
        }
        Print2D obj = new Print2D();
        obj.Array(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter the rows of Array");
        int a = sc.nextInt();

        System.out.println("Enter the column of Array");
        int b = sc.nextInt();


        Array1Dto2D(arr,a,b);
            }
        }

