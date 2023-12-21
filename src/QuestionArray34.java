import java.util.Scanner;

public class QuestionArray34 {

    static void middleindex(int[] arr){
        int x=arr.length;

        Prefix obj2 = new Prefix();
        int[] ans1 = obj2.Array(arr);

        Suffix obj3 = new Suffix();
        int[] ans2 = obj3.Array(arr);
        int a=-1;

        for(int i=0; i<x; i++){
            if(ans1[i]==ans2[i]){
                a=i;

            }
        }
        System.out.println("The middleindex number is "+a);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        middleindex(arr);

    }
}
