import java.util.Scanner;

public class QuestionArray25 {
    static void oddeven(int[] arr){
        int x=arr.length;

        int ans[]=new int[x];
        int idx=0;
        for(int i=0; i<x; i++){
            if(arr[i]%2==0){
                ans[idx]=arr[i];
                idx++;
            }
        }
        for(int i=0; i<x; i++){
            if(arr[i]%2!=0){
            ans[idx]=arr[i];
            idx++;
            }
        }
        Print obj2 = new Print();
        obj2.Array(ans);
    }

    static void oddeven2(int[] arr){
        int x=arr.length;

        int i=0;
        int j=x-1;
        int a;

        while(i<j) {
            if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                a = arr[i];
                arr[i] = arr[j];
                arr[j] = a;
            }
            if (arr[i] % 2 == 0) {
                i++;
            }
            if (arr[j] % 2 != 0) {
                j--;
            }
        }
        Print obj3 = new Print();
        obj3.Array(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[]= obj.Array();

        oddeven2(arr);
    }
}
