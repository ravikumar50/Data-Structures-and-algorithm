import java.util.Scanner;

public class QuestionArray12 {

    static int max(int[] arr){

        int max= Integer.MIN_VALUE ;
        int x = arr.length;
        for(int i=0; i<x; i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("The maximum elelment is : "+max(arr));
    }
}
