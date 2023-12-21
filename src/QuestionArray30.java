import java.util.Scanner;

public class QuestionArray30 {

    static boolean twoparts(int[] arr){
        int x = arr.length;

        Prefix obj2 = new Prefix();
        int[] ans1 = obj2.Array(arr);

        Suffix obj3 = new Suffix();
        int [] ans2 = obj3.Array(arr);

        for(int i=0; i<x-1; i++){
             if(ans1[i]==ans2[i+1]){
                 return true;
             }
        }
        return false;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int [] arr = obj.Array();

        twoparts(arr);

    }
}
