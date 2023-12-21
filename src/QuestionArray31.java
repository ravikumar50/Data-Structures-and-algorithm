import java.util.Scanner;
import java.util.Arrays;

public class QuestionArray31 {

    static int split(int[] arr , int m) {
        int x = arr.length;

        Arrays.sort(arr);

        Prefix obj2 = new Prefix();
        int[] ans1 = obj2.Array(arr);

        Suffix obj3 = new Suffix();
        int[] ans2 = obj3.Array(arr);

        int sum = ans2[m] - ans1[m - 1];

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter the number");
        int m=sc.nextInt();

        System.out.println("Maximum difference is "+split(arr,m));

    }
}
