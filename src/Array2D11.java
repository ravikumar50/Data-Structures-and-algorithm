import java.util.Scanner;

public class Array2D11 {


    static void SpiralMatrix(int[][] arr , int r, int c){
        int toprow=0; int botmrow=r-1; int lftcol=0; int rgtcol=c-1;

        int idx=0;

        while(idx<r*c){
            for(int j=lftcol; j<=rgtcol && idx<r*c; j++){
                System.out.print(arr[toprow][j]+" ");
                idx++;
            }
            toprow++;
            for(int i=toprow; i<=botmrow && idx<r*c; i++){
                System.out.print(arr[i][rgtcol]+" ");
                idx++;
            }
            rgtcol--;
            for(int j=rgtcol; j>=lftcol && idx<r*c; j--){
                System.out.print(arr[botmrow][j]+" ");
                idx++;
            }
            botmrow--;
            for(int i=botmrow; i>=toprow && idx<r*c; i--){
                System.out.print(arr[i][lftcol]+" ");
                idx++;
            }
            lftcol++;
        }


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
        SpiralMatrix(arr,r1,c1);
    }
}
