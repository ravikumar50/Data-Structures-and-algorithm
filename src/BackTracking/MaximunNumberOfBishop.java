package BackTracking;

public class MaximunNumberOfBishop {

    static int max = -1;

    static boolean isSafe(char board[][], int row, int col){

        int n = board.length;

        //North-West

        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='B') return false;
        }

        // South-East

        for(int i=row,j=col; i<n && j<n; i++,j++){
            if(board[i][j]=='B') return false;
        }

        // South-West

        for(int i=row,j=col; i<n && j>=0; i++,j--){
            if(board[i][j]=='B') return false;
        }

        // North-East

        for(int i=row,j=col; i>=0 && j<n; i--,j++){
            if(board[i][j]=='B') return false;
        }

        return true;
    }

    static void maxBishop(char arr[][], int row, int col, int num){
        int n = arr.length;
        if(row==n){
            if(num>=3) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }

            max=Math.max(max,num);
            return;
        }

        if(isSafe(arr,row,col)){
            arr[row][col]='B';

            if(col!=n-1) maxBishop(arr,row,col+1,num+1);
            else maxBishop(arr,row+1,0,num+1);

            arr[row][col]='.';
        }

        if(col!=n-1) maxBishop(arr,row,col+1,num);
        else maxBishop(arr,row+1,0,num);

        return;

    }
    public static void main(String[] args) {

        int n = 4;
        char arr[][] = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]='.';
            }
        }

        maxBishop(arr,0,0,0);

        System.out.println(max);
    }
}
