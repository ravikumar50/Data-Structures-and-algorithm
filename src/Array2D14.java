import java.util.Scanner;

public class Array2D14 {

    static void UpperMatrix(int [][] arr , int n){

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j>=i){
                        System.out.print(arr[i][j] + " ");
                    }
                else{
                    System.out.print("  ");
                }
                }
            System.out.println();

            }
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of square matrix");
        int n = sc.nextInt();


        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        UpperMatrix(arr,n);


    }
}
