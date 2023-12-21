import java.util.Scanner;

public class QuestionArray1 {
    public static void main(String[] args) {
         int[] arr = {3,5,4,3,5,7,3,4,32,3,7,3};
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int a = sc.nextInt();
         int ans=0;

         for(int n=0; n<arr.length; n++){
             if(arr[n]==a)
                 ans++;
         }
        System.out.println(ans);
    }
}
