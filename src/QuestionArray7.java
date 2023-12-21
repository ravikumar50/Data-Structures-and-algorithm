import java.util.Scanner;
import java.util.Arrays;

public class QuestionArray7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr1= obj.Array();

        Arrays.sort(arr1);

        System.out.println("Enter the number");
        int k = sc. nextInt();

        System.out.println("The "+k+"th smallest element is "+arr1[k-1]);
    }
}
