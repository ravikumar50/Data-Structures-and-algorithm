import java.util.Scanner;

class Transpose{
    public int[][] Array(int[][] arr, int r, int c){
        int[][] ans = new int[c][r];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                ans[j][i]=arr[i][j];
            }
        }
        return ans;
    }
}

public class Array2D5 {

    static void Transpose2(int[][] arr , int r, int c){ // only for square matrix
        int a;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){    // or for(int j=i)
                if(i<j){              // next line
                    a=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=a;
                }
            }
        }
        Print2D obj3 = new Print2D();
        obj3.Array(arr);
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
        Transpose2(arr,r1,c1);



    }
}

