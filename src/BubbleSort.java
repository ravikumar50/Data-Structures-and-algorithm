import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int x = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = x;
                }
            }
        }
    }


    static void bubbleSortoptimized(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            boolean flag = false;
            for(int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    int x = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = x;
                }
            }
            if(flag==false) return;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        bubbleSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
    }
}
