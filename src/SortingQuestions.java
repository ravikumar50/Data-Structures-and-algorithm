import java.util.Scanner;
import java.util.Arrays;

public class SortingQuestions {

    static void ques1(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] == 0 && arr[j + 1] != 0) {
                    int a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = a;
                }
            }
        }
    }

    static void stringCompare(String s[]) {
        for (int i = 0; i < s.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < s.length; j++) {
                if (s[min].compareTo(s[j]) > 0) {
                    min = j;
                }
            }
            String a = s[min];
            s[min] = s[i];
            s[i] = a;
        }
    }

    static int kthminimum(int arr[], int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = arr[k - 1];
        return ans;
    }

    static int minimumsum(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int k = 10;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i = i + 2) {
            num1 = (num1 * k) + arr[i];
        }
        for (int i = 1; i < n; i = i + 2) {
            num2 = (num2 * k) + arr[i];
        }

        return num1 + num2;
    }

    static void ques2(int arr[]) {
        int n = arr.length;
        int ans[] = Arrays.copyOf(arr, n);

        Arrays.sort(ans);
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i] == arr[j]) {
                    arr[j] = k++;

                    break;
                }
            }
        }
    }

    static void insertionSortRecursive(int arr[], int idx){
        if(idx==arr.length) return;
        int j=idx;
        while(j>0 && arr[j]<arr[j-1]){
            int a=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=a;
            j--;
        }
        insertionSortRecursive(arr,idx+1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();

        insertionSortRecursive(arr,1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
