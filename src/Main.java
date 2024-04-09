
import java.util.Scanner;

public class Main {

    static void display(char board[][]){
        int n = board.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }

    static boolean isSafe(char board[][], int row , int col){

        int n = board.length;

        // check row;

        for(int j=0; j<n; j++){
            if(board[row][j]=='Q') return false;
        }

        // check column

        for(int i=0; i<n; i++){
            if(board[i][col]=='Q') return false;
        }

        // check diagonal

        //North-West

        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q') return false;
        }

        // South-East

        for(int i=row,j=col; i<n && j<n; i++,j++){
            if(board[i][j]=='Q') return false;
        }

        // South-West

        for(int i=row,j=col; i<n && j>=0; i++,j--){
            if(board[i][j]=='Q') return false;
        }

        // North-East

        for(int i=row,j=col; i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }

    static void Nqueens(char board[][], int row){
        int n = board.length;

        if(row==n){
            ans++;
            display(board);
            return;
        }

        for(int j=0; j<n; j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                Nqueens(board,row+1);
                board[row][j]='.';
            }
        }
    }

    static int ans;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Queens");
        int n = sc.nextInt();
        char board[][] = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        ans = 0;
        Nqueens(board,0);
        System.out.println("Total "+ans+" position Found");
    }
}
