import java.util.Scanner;

public class RadixSort {


    static int max(int arr[]){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }

    static void countSort(int arr[], int place){

        int n = arr.length;
        int count[] = new int[10];

        for(int i=0; i<n; i++){
            int idx = (arr[i]/place)%10;
            count[idx]++;
        }

        for(int i=1; i<count.length; i++){     //making prefix sum array
            count[i]+=count[i-1];
        }
        int ans[] = new int[n];
        for(int i=n-1; i>=0; i--){
            int idx = count[(arr[i]/place)%10]-1;
            ans[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        for(int i=0; i<n; i++){
            arr[i]=ans[i];
        }
    }


    static void radixSort(int arr[]){
        int n = arr.length;
        int max = max(arr);

        for(int place=1; max/place>0; place*=10){
            countSort(arr,place);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();

        radixSort(arr);

        Print obj2 = new Print();
        obj2.Array(arr);
    }
}
