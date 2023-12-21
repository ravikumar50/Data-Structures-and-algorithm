import java.util.Scanner;

public class QuetionArray14 {

    static int repeat(int[] arr) {
        int x = arr.length;
        int ans=-1;

        for (int i = 0; i < x; i++) {
            for (int j = i + 1; j < x; j++) {
                if (arr[i] == arr[j])
//                    ans=arr[i]; // for finding last repeated digit
                    return arr[i];  // this will terminate all the loops
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int [] arr = obj.Array();

        System.out.println("The first repeated digit is : "+repeat(arr));
    }
}
