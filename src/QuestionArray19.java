import java.util.Scanner;

public class QuestionArray19 {

    static void reverse(int[] arr){

        int x=arr.length;
        int a;
//        int[] arr2 = new int[x];
        for(int i=0; i<x/2; i++){
            a=arr[i];
            arr[i]=arr[x-1-i];
            arr[x-1-i]=a;

        }
        for(int n=0; n<x; n++){
            System.out.print(arr[n]+" ");
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        reverse(arr);
    }
}
