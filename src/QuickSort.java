import java.util.Scanner;
import java.util.Arrays;
public class QuickSort {

    static void Swap(int arr[], int i, int j){
        int a = arr[i];
        arr[i]= arr[j];
        arr[j]=a;
    }

    static void quickSort(int arr[], int st, int end){

        if(st>=end) return;
        int pivot = partition(arr,st,end);
        quickSort(arr,st,pivot-1);
        quickSort(arr,pivot+1,end);
    }


    static int partition(int arr[], int st, int end){
        int pivotElement = arr[st];             //  To avoid worst case possibility choose
                                                //  random pivot element between st and end.
        int count = 0;                          // import java.util.Random;
                                                // Random obj = new Random();
        for(int i=st+1; i<=end; i++) {          // int k = obj.nextInt(1,100)   enter range in between
            if (pivotElement >= arr[i]) count++;
        }
        int pivot = st+count;
        Swap(arr,st,pivot);

        int i=st;
        int j=end;

        while(i<pivot && j>pivot){
            if(arr[j]<arr[pivot] && arr[i]>arr[pivot]){
                Swap(arr,i,j);
                i++;
                j--;
            }
            if(arr[i]<arr[pivot]) i++;
            if(arr[j]>arr[pivot]) j--;
        }

        return pivot;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();
        int n = arr.length;

        quickSort(arr, 0, n-1);

        Print obj2 = new Print();
        obj2.Array(arr);
    }
}
