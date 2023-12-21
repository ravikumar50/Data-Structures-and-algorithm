package BackTracking;

public class MaximunNumberOfRook {

    static int max = -1;

    static boolean isSafe(char arr[][], int row, int col){
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i][col]=='H') return false;
        }

        for(int j=0; j<n; j++){
            if(arr[row][j]=='H') return false;
        }

        return true;
    }

    static void maxRook(char arr[][], int row,int num){
        int n = arr.length;

        if(row==n){

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }

            System.out.println();
            max=Math.max(max,num);
            return;
        }

        for(int j=0; j<n; j++){
            if(isSafe(arr,row,j)){
                arr[row][j]='H';
                maxRook(arr,row+1,num+1);
                arr[row][j]='.';  //backtracking;
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char arr[][] = new char[n][n];

        for (int i = 0; i < n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]='.';
            }
        }

        maxRook(arr,0,0);
        System.out.println(max);
    }
}
