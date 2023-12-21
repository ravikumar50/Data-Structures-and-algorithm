import java.util.Scanner;
import java.util.Arrays;

public class QuestionArray4 {

    static int[] KthsmallestandKthlargestelements(int[] arr) {

        Arrays.sort(arr);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter which smallest and largest element do you want");
        int k = sc.nextInt();
        int[] ans = {arr[k-1],arr[arr.length-k]};
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int a = sc.nextInt();

        int[] arr = new int[a];
        System.out.println("Enter " + a + " elements of array");

        for (int n = 0; n < a; n++) {
            arr[n] = sc.nextInt();
        }
        int[] ans = KthsmallestandKthlargestelements(arr);
        System.out.println(ans);


    }
}



