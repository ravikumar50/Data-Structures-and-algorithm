import java.util.Scanner;

public class QuestionArray26 {
    static void sort(int[] arr) {
        int x = arr.length;

        int i = 0;
        int j = x - 1;

        while (i <= j) {
            arr[i] = arr[i] * arr[i];
            if (i == j)
                break;
            arr[j] = arr[j] * arr[j];
        }

        int a;
        for(int m=0; m<x-1; m++) {
            for (int n = 0; n < x; n++) {
                if (arr[i] > arr[i + 1]) {
                    a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;

                }
            }
        }


        Print obj2 = new Print();
        obj2.Array(arr);
    }

    static void Sort(int[] arr) {
        int x = arr.length;
        int[] ans = new int[x];
        int k = 0;
        int i = 0;
        int j = x - 1;

        while (i <= j) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                ans[k] = arr[i] * arr[i];
                k++;
                i++;
            } else {
                ans[k] = arr[j] * arr[j];
                k++;
                j--;
            }
        }  // for without reversing the arr
        // start k=x-1 and instead of k++ do k--
        // greater number will automatically come on the last place
        int l=0;
        int r=x-1;
        int m;
        while(l<r){
            m=ans[l];
            arr[l]=arr[r];
            arr[r]=m;
            l++; r--;
        }
        Print obj3 = new Print();
        obj3.Array(ans);
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        sort(arr);
    }
}
