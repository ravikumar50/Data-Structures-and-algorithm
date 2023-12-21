import java.util.Scanner;

public class InsertionSort {

    static void insertionSort(int arr[]){
        int n=arr.length;

        for(int i=1; i<n; i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int a=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=a;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();

        insertionSort(arr);

        Print obj2 = new Print();
        obj2.Array(arr);
    }
}
