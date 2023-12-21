import java.util.Scanner;

public class QuestionArray16 {

    static String difference(int[] arr, int k){

        int x = arr.length;
        String ans = "No";
        int a ;

        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                if(arr[i]-arr[j]<0) {
                    a = (arr[i] - arr[j]) * -1;
                    if (a == k) {
                        ans = "Yes";
                    }
                }else if(arr[i]-arr[j]>=0 && arr[i]-arr[j]==k){
                    ans="Yes";
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int [] arr = obj.Array();

        System.out.println("What difference do you want?");
        int k = sc.nextInt();

        System.out.println(difference(arr,k));
    }
}
