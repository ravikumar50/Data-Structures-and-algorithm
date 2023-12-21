import java.util.Scanner;

public class QuestionArray13 {

    static int findmax(int[] arr) {

        int max = Integer.MIN_VALUE;
        int x = arr.length;
        for (int i = 0; i < x; i++) {
            if (arr[i] > max) {
                max=arr[i];
            }
        }
        return max;
    }

    static int findsecondmax(int[] arr) {

        int max = findmax(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        int seconMax = findmax(arr);
        return seconMax;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();


        System.out.println("The second maximum element is : "+findsecondmax(arr));

    }
}
