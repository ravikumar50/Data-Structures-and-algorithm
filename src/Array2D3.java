import java.util.Scanner;

public class Array2D3 {

    static void Multiply(int[][] arr1, int[][] arr2, int r1, int c1, int r2, int c2){

        if(c1!=r2){
            System.out.println("Array multiplication is not possible");
        }
        else{

            int[][] ans = new int[r1][c2];

            for(int i=0; i<r1; i++){
                for(int j=0; j<c2; j++){
                    for(int k=0; k<c1; k++){

                        ans[i][j]+=arr1[i][k]*arr2[k][j];

                    }
                }
            }
            Print2D obj = new Print2D();
            obj.Array(ans);
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


        System.out.println("Enter the number of rows of 2nd array");
        int r2 = sc.nextInt();

        System.out.println("Enter the number of column of 2nd array");
        int c2 = sc.nextInt();

        int[][] arr2 = new int[r2][c2];

        for (int i = 0; i < r2; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < c2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        Multiply(arr1,arr2,r1,c1,r2,c2);

    }
}
