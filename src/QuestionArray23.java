import java.util.Scanner;

public class QuestionArray23 {

    static void Alternatenegativeandpositive(int[] arr) {
        int x = arr.length;

        int[] ans = new int[x];
        int j = 0;
        int k = 1;

        for (int i = 0; i < x; i++) {
            if (arr[i] < 0) {
                ans[j] = arr[i];
                j = j + 2;
            } else if(arr[i]>=0) {
                ans[k] = arr[i];
                k=k+2;
            }
        }
        for (int i = 0; i < x; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        Alternatenegativeandpositive(arr);

        }

    }
