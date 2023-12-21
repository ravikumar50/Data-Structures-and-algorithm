import java.util.Scanner;

public class QuestionArray24Same2 {
    static void sort(int[] arr) {
        int x = arr.length;

        int i = 0;
        int j = x - 1;
        int a;

        while (i < j) {

            if (arr[i] == 1 && arr[j] == 0) {
                a = arr[i];
                arr[i] = arr[j];
                arr[j] = a;

                i++;
                j--;
            }

            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }
        }

        Print obj2 = new Print();
        obj2.Array(arr);
        }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        sort(arr);
    }
}
