import java.util.Scanner;


public class Array2D8 {


    static void Teoplitz(int[][] arr, int r, int c){

        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                if(arr[i][j]!=arr[i-1][j-1]){
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows");

        int r = sc.nextInt();

        System.out.println("Enter number of column");
        int c = sc.nextInt();

        int [][] arr = new int[r][c];

        for(int i=0; i<r; i++){
            System.out.println("Enter the elements of "+i+" row");
            for(int j=0; j<c; j++){
                arr[i][j]=sc.nextInt();
            }
        }
          Teoplitz(arr,r,c);
    }
}
