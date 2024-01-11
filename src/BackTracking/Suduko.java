package BackTracking;
import java.util.Scanner;


public class Suduko {

    static int check=-1;

    static boolean isValid(int arr[][], int row, int col, int s){
        int n = arr.length;

        if(row==n){
            return true;
        }

        for(int i=0; i<n; i++){
            if(arr[i][col]==s) return false;
        }


        for(int j=0; j<n; j++){
            if(arr[row][j]==s) return false;
        }

        int a = (row/3)*3;
        int b = (col/3)*3;



        for(int i=a; i<a+3; i++){
            for(int j=b; j<b+3; j++){
                if(arr[i][j]==s) return false;
            }
        }
        return true;
    }

    static void solver(int arr[][], int row, int col){

        if(row==9){

            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

            check=1;
            return;
        }
        else if(arr[row][col]==0){
            for(int i=1; i<=9; i++){
                if(isValid(arr,row,col,i)){
                    arr[row][col]=i;
                    if(col!=8) solver(arr,row,col+1);
                    else solver(arr,row+1,0);

                    if(check==1) return;
                    arr[row][col]=0;   // backtracking
                }
            }
        }else{
            if(col!=8) solver(arr,row,col+1);
            else solver(arr,row+1,0);
        }
        return;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[][] = {{5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}};



        solver(arr,0,0);

    }
}
