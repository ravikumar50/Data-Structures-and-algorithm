import java.util.Scanner;

public class Array2D6 {

    static void Check(int[][] arr, int a, int b, int c) {




        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {

                if(arr[i][j]==c) {
                    System.out.println("Found It at " + i + "th rows and " + j + "th column");
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int a= sc.nextInt();

        System.out.println("Enter the number of column");
        int b=sc.nextInt();

        int[][] arr = new int[a][b];

        for(int i=0; i<a; i++){
            System.out.println("Enter the elements of "+i+" row");
            for(int j=0; j<b; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the number do you want to check");
        int c=sc.nextInt();

        Check(arr,a,b,c);
    }
}
