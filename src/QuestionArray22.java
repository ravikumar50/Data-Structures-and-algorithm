import java.util.Scanner;

public class QuestionArray22 {

    static void repeat(int[] arr){
        int x=arr.length;



        for(int i=0; i<x; i++){
            for(int j=i+1; j<x; j++){
                if(arr[i]==arr[j]){
                    System.out.println(i+1);
                    return;
                }
            }
        }
        System.out.println("-1");

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        repeat(arr);



    }
}
