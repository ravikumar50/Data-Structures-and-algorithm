import java.util.Scanner;

public class QuestionArray15 {

    static int findmin(int[] arr){
        int x = arr.length;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<x;i++){
            if (min > arr[i]){
                min=arr[i];

            }
        }
        return min;
    }
    static int findsecondmin(int[] arr){
        int x = arr.length;
        int min = findmin(arr);

        for(int i=0; i<x; i++){
            if(arr[i]==min)
                arr[i]=Integer.MAX_VALUE;
        }
        int secondmin = findmin(arr);
        return secondmin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("The smallest element is : "+findmin(arr));

        System.out.println("The second smallest element is : "+findsecondmin(arr));
    }
}
