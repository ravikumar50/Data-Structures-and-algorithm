import java.util.Scanner;

public class Array2D13 {

    static void Rectanglesumbruteforce(int[][] arr, int r1, int c1, int r2, int c2){

        int sum=0;

        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                sum+=arr[i][j];
            }
        }
        System.out.println("The sum is "+sum);
    }

    static void RectanglesumusingPrefix(int[][] arr, int r, int c, int r1, int c1, int r2, int c2) {


        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        int sum=0;
            for (int i = r1; i<=r2; i++){
                if(c1==0){
                sum += arr[i][c2];
            } else{
                sum += arr[i][c2] - arr[i][c1 - 1];
            }
        }
        System.out.println("Final sum is "+sum);
    }

    static void RectanglesumusingRowandcolumnPrefix(int[][] arr, int r, int c, int r1, int c1, int r2, int c2){

        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j] += arr[i][j -1];
            }
        }

        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                arr[i][j] += arr[i-1][j];
            }
        }
        int sum=0; int a=0; int b=0; int m=0;
        a=arr[r1-1][c2];
        b=arr[r2][c1-1];
        m=arr[r1-1][c1-1];
        sum=arr[r2][c2];

        int ans=(sum+m)-(a+b);

        System.out.println(ans);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows of 1st array");
        int r = sc.nextInt();

        System.out.println("Enter the number of column of 1st array");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the first coordinate");
        int r1=sc.nextInt();
        int c1=sc.nextInt();

        System.out.println("Enter the second coordinate");
        int r2=sc.nextInt();
        int c2=sc.nextInt();

        Rectanglesumbruteforce(arr,r1,c1,r2,c2);
        RectanglesumusingPrefix(arr,r,c,r1,c1,r2,c2);
        RectanglesumusingRowandcolumnPrefix(arr,r,c,r1,c1,r2,c2);
    }
}
