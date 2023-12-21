import java.util.Scanner;

public class QuestionArray5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] ans = obj.Array();


        int[] arr2 = new int[ans.length];
        int idx = 0;
        int x = 0;
        for (int n = 0; n < ans.length; n++) {
            if (ans[n] > 0) {
                arr2[idx] = ans[n];
                idx++;
            }
        }
        for (int n = 0; n < ans.length; n++) {
            if (ans[n]<= 0) {
                arr2[idx] = ans[n];
                idx++;
            }
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(arr2[i]+" ");
        }
        }
    }

