import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        int x = arr.length;
        int a;

        for (int m = 0; m < x; m++) {
            for (int n = 0; n < x-1; n++) {
                if (arr[n] > arr[n + 1]) {
                    a = arr[n];
                    arr[n] = arr[n + 1];
                    arr[n + 1] = a;
                }
            }
        }

    }
}