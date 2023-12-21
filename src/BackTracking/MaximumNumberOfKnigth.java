package BackTracking;

import java.util.Scanner;

public class MaximumNumberOfKnigth {


    static int max = -1;

    static boolean isSafe(char arr[][], int row, int col){

        int n = arr.length;

        int i,j;

        // 2 up 1 Rgt
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && arr[i][j]=='K') return false;


        // 2 up 1 left

        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 &&  arr[i][j]=='K')return false;


        // 2 Down 1 left

        i=row+2;
        j=col-1;
        if(i<n && j>=0 && arr[i][j]=='K') return false;


        // 2 Down 1 Rgt

        i=row+2;
        j=col+1;
        if(i<n && j<n && arr[i][j]=='K') return false;


        // 2 Rgt 1 Down

        i=row+1;
        j=col+2;
        if(i<n && j<n && arr[i][j]=='K') return false;


        // 2 Rgt 1 Up

        i=row-1;
        j=col+2;
        if(i>=0 && j<n && arr[i][j]=='K') return false;

        // 2 Left 1 Down

        i=row+1;
        j=col-2;
        if(i<n && j>=0 && arr[i][j]=='K') return false;

        // 2 Left 1 Up

        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && arr[i][j]=='K') return false;

        return true;
    }

    static void maxKnigth(char board[][], int row, int col, int num){
        int n = board.length;

        if(row==n){
            if(num>=4) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }


            max=Math.max(max,num);
            return;
        }

        if(isSafe(board,row,col)) {

            board[row][col] = 'K';

            if (col == n - 1) maxKnigth(board, row + 1, 0,num+1);
            else  maxKnigth(board, row, col + 1,num+1);

            board[row][col] = '.';
        }



        if (col == n - 1) maxKnigth(board, row + 1, 0,num);
        else  maxKnigth(board, row, col + 1,num);
        return;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 3;

        char board[][] = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }

        maxKnigth(board,0,0,0);
        System.out.println(max);
    }
}
