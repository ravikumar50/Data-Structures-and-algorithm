import java.util.Scanner;

public class CountSort {


    static void countSort(int arr[]){

        int n = arr.length;

        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>max) max = arr[i];
        }

        int count[] = new int[max+1];

        for(int i=0; i<n; i++){
            count[arr[i]]++;
        }
        int k=0;

        for(int i=0; i< count.length; i++){
            for(int j=0; j<count[i]; j++){
                arr[k++]=i;
            }
        }
    }

    static int[] countSortMaintainingTheRelativeOrder(int arr[]) {
        int n = arr.length;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int count[] = new int[max + 1];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < count.length; i++) {     //making it prefix sum array;
            count[i] += count[i - 1];
        }

        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int idx = count[arr[i]]-1;
                    ans[idx] = arr[i];
                    count[arr[i]]--;
            }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();

        int ans[]=countSortMaintainingTheRelativeOrder(arr);

        Print obj2 = new Print();
        obj2.Array(ans);
    }
}
