import java.util.Scanner;

public class new4 {

    static void sum(int arr1[][], int arr2[][]){
        int n1 = arr1.length;
        int m1 = arr1[0].length;
        int n2 = arr2.length;
        int m2 = arr2.length;

        if(n1!=n2 || m1!=m2){
            System.out.println("Addition is not Possibble");
            return;
        }else {
            int ans[][] = new int[n1][m1];

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    ans[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            System.out.println("Addition of Both Matrix is");

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    static void sub(int arr1[][], int arr2[][]){
        int n1 = arr1.length;
        int m1 = arr1[0].length;
        int n2 = arr2.length;
        int m2 = arr2.length;

        if(n1!=n2 || m1!=m2){
            System.out.println("Subtraction is not Possibble");
            return;
        }else {
            int ans[][] = new int[n1][m1];

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    ans[i][j] = arr1[i][j] - arr2[i][j];
                }
            }

            System.out.println("Subtraction of Both Matrix is");

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    static void multiply(int arr1[][], int arr2[][]) {
        int n1 = arr1.length;
        int m1 = arr1[0].length;
        int n2 = arr2.length;
        int m2 = arr2.length;

        if(m1!=n2){
            System.out.println("Multiplication is not possible");
            return;
        }else{
            int ans[][] = new int[n1][m2];

            for(int i=0; i<n1; i++){
                for(int j=0; j<m2; j++){
                    for(int k=0; k<m1; k++){
                        ans[i][j] += arr1[i][k]*arr2[k][j];
                    }
                }
            }
            System.out.println("Multiplication of Both Matrix is");

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }

        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = Integer.valueOf(args[0]);
        int m1 = Integer.valueOf(args[1]);
        int n2 = Integer.valueOf(args[2]);
        int m2 = Integer.valueOf(args[3]);


        int arr1[][] = new int[n1][m1];

        System.out.println("Enter the elements of the 1st matrix");
        for(int i=0; i<n1; i++){
            for(int j=0; j<m1; j++){
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of rows and column of 2nd Matrix");

        int arr2[][] = new int[n2][m2];

        System.out.println("Enter the elements of the 2nd matrix");
        for(int i=0; i<n2; i++){
            for(int j=0; j<m2; j++){
                arr2[i][j] = sc.nextInt();
            }
        }

        System.out.println("1st Matrix is");

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("2nd Matrix is");

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        sum(arr1,arr2);
        System.out.println();
        sub(arr1,arr2);
        System.out.println();
        multiply(arr1,arr2);

    }
}
