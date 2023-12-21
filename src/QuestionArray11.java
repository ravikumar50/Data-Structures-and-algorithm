import java.util.Scanner;

public class QuestionArray11 {
    static void unique(int[] arr) {

        int x = arr.length;
        for (int i = 0; i < x; i++) {
            int ans = 0;

            for (int j = 0; j < x; j++) {
                if (arr[i] == arr[j])
                    ans++;
            }
            if (ans == 1)
                System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        unique(arr);
    }
}
