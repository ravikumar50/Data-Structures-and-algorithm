import java.util.Arrays;
import java.util.Scanner;

public class QuestionArray18 {

    static void missing(int[] arr){

        Arrays.sort(arr);
        int x=arr.length;

        for(int i=1; i<x; i++){
            int ans = 0;
            for(int j=0; j<x; j++){
                if(arr[j]==i)
                    ans++;
            }
            if(ans==0)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int a = sc.nextInt();

        System.out.println("Enter the "+(a-1)+" elements of Array");
        int[] arr = new int[a-1];

        for(int n=0; n<a-1; n++){
            arr[n]=sc.nextInt();
        }
        missing(arr);
    }
}
