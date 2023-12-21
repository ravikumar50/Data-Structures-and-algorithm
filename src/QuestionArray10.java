import java.util.Scanner;

public class QuestionArray10 {

    static int printsum(int[] arr, int a){
        int ans = 0;
        int x = arr.length;

        for(int i=0; i<x; i++){
            for(int j=i+1; j<x; j++){
                for(int k=j+1; k<x; k++){
                    if(arr[i]+arr[j]+arr[k]==12)
                        ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter the targeted sum");
        int a = sc.nextInt();

        System.out.println(printsum(arr,a));
    }
}
