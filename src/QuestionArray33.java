import java.util.Scanner;

public class QuestionArray33 {

    static void altitude(int[] arr){
        int x = arr.length;

        int ans=0;
        int gain=0;

        for(int i=0; i<x; i++){
            gain=gain+arr[i];
            if(gain>ans){
                ans=gain;
            }
        }
        System.out.println("Maximum altitude is "+ans);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        altitude(arr);

    }
}
