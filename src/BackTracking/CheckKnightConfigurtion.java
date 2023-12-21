package BackTracking;

import java.util.Scanner;

public class CheckKnightConfigurtion {

    static boolean helper(int arr[][], int row, int col, int num){
        int n = arr.length;

        if(arr[row][col]==n*n-1){
            return true;
        }

        int i,j;

        // 2 up 1 Rgt
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && arr[i][j]==num+1) return helper(arr,i,j,num+1);


        // 2 up 1 left

        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 &&  arr[i][j]==num+1)return helper(arr, i,j,num+1);


        // 2 Down 1 left

        i=row+2;
        j=col-1;
        if(i<n && j>=0 && arr[i][j]==num+1) return helper(arr, i,j,num+1);


        // 2 Down 1 Rgt

        i=row+2;
        j=col+1;
        if(i<n && j<n && arr[i][j]==num+1) return helper(arr, i,j,num+1);


        // 2 Rgt 1 Down

        i=row+1;
        j=col+2;
        if(i<n && j<n && arr[i][j]==num+1) return helper(arr, i,j,num+1);


        // 2 Rgt 1 Up

        i=row-1;
        j=col+2;
        if(i>=0 && j<n && arr[i][j]==num+1) return helper(arr, i,j,num+1);

        // 2 Left 1 Down

        i=row+1;
        j=col-2;
        if(i<n && j>=0 && arr[i][j]==num+1) return helper(arr, i,j,num+1);

        // 2 Left 1 Up

        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && arr[i][j]==num+1) return helper(arr, i,j,num+1);

        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // int n = 5;

        int arr[][] ={{24,11,22,17,4},
                {21,16,5,12,9},
                {6,23,10,3,18},
                {15,20,1,8,13},
                {0,7,14,19,2}};

        if(arr[0][0]!=0){
            System.out.println("False");
            return;
        }

        boolean ans = helper(arr, 0, 0, 0);

        System.out.println(ans);
    }
}
