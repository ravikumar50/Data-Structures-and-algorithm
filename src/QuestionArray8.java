import java.util.Scanner;

public class QuestionArray8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            NewArr obj = new NewArr();
            int[] arr1 = obj.Array();
            int[] arr2 = obj.Array();
            boolean check = true;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i])
                    check = false;
            }
            System.out.println(check);
        }
    }

