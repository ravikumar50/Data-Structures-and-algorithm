import java.util.Scanner;

public class QuestionArray9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter the targeted sum");
        int k = sc.nextInt();
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==k)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
