import java.util.Scanner;


class NewArr2D {
    public int[][] Array() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int r = sc.nextInt();

        System.out.println("Enter the number of column");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            System.out.println("Enter elements of : " + i + " rows");
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        return arr;
    }
}

class Print2D{
    public void Array(int[][] arr){

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+"   ");
            }
            System.out.println();
        }
    }
    }

public class Array2D1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr2D obj = new NewArr2D();
        int[][] arr = obj.Array();

        Print2D obj2 = new Print2D();
        obj2.Array(arr);


    }
}
