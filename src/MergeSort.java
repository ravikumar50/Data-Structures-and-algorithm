import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {


    static void mergeSort(int[] arr,int a, int b) {

        int mid = (a + b) / 2;

        if(a>=b) return;

        mergeSort(arr, a, mid);
        mergeSort(arr, mid + 1, b);

        mergingTwoSortedArray(arr, a, mid, b);

    }


    static void mergingTwoSortedArray(int[] arr, int l, int mid, int r){


            int x = mid-l+1;
            int y = r-mid;
            int[] left = new int[x];
            int[] rgt = new int[y];

            for(int i=0; i<x; i++) left[i]=arr[l+i];
            for(int j=0; j<y; j++) rgt[j]=arr[mid+1+j];

            int i=l;
            int j=0;
            int k=0;
            while(j<x && k<y){
                if(left[j]<=rgt[k]){
                    arr[i++]=left[j++];
                }else{
                    arr[i++]=rgt[k++];
                }
            }


                while(j<x) {
                    arr[i++] = left[j++];
                }
                while(k<y){
                    arr[i++]=rgt[k++];
                }
            }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();
        int n = arr.length;

        mergeSort(arr,0,n-1);

        Print obj2 = new Print();
        obj2.Array(arr);


    }
}
