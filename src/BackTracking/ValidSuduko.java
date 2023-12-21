package BackTracking;

import java.util.Scanner;

public class ValidSuduko {

    static boolean isValid(String arr[][], int row, int col){

        int n = arr.length;
        if(row==n){
            return true;
        }

        if(arr[row][col]!="."){

            for(int i=0; i<n; i++){
                if(i!=row && arr[i][col]==arr[row][col]) return false;
            }


            for(int j=0; j<n; j++){
                if(j!=col && arr[row][j]==arr[row][col]) return false;
            }

            int a = (row/3)*3;
            int b = (col/3)*3;



            for(int i=a; i<a+3; i++){
                for(int j=b; j<b+3; j++){
                    if(i!=row && j!=col && arr[i][j]==arr[row][col]) return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String arr[][] = {{".",".","4",".",".",".","6","3","."},
        {".",".",".",".",".",".",".",".","."},
        {"5",".",".",".",".",".",".","9","."},
        {".",".",".","5","6",".",".",".","."},
        {"4",".","3",".",".",".",".",".","1"},
        {".",".",".","7",".",".",".",".","."},
            {".",".",".","5",".",".",".",".","."},
                {".",".",".",".",".",".",".",".","."},
                    {".",".",".",".",".",".",".",".","."}};

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(isValid(arr,i,j)==false){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
}
