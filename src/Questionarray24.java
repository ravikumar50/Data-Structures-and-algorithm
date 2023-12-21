import java.util.Scanner;

public class Questionarray24 {
    static void sort(int[] arr) {
        int x = arr.length;

        int[] ans = new int[x];

        int idx = 0;
        for (int i = 0; i < x; i++) {
            if (arr[i] == 0) {
                ans[idx] = arr[i];
                idx++;
            }
        }
        for (int i = 0; i < x; i++) {
            if (arr[i] == 1) {
                ans[idx] = arr[i];
                idx++;
            }
        }
        Print obj = new Print();
        obj.Array(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NewArr obj2 = new NewArr();
        int[] arr = obj2.Array();

        sort(arr);
    }
}
