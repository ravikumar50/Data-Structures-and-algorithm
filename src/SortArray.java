import java.util.Scanner;

public class SortArray {

    static void abs(int[] arr){
        int c = arr.length;


        int x;
       for(int i=0; i<c; i++){
        for(int j=i; j<c; j++) {
            if (arr[i] > arr[j]) {
                x=arr[i];
                arr[i] = arr[j];
                arr[j]=x;


            }
        }
        }
        Print obj2 = new Print();
        obj2.Array(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        abs(arr);

    }
}
