import java.util.Scanner;

public class QuestionArray32 {

    static void sequence(int[] arr){
        int x= arr.length;

        int a=0;

        for(int i=0; i<x; i++){
            if(arr[i]==0){
                a++;
            }
        }
        int b=x-a;
         int ans;

         if(a==0 || b==0){
            System.out.println("-1");
        }
         else if(a>=b){
             System.out.println("Maximum length is "+2*b);
         }
         else if(b>a){
             System.out.println("Maximum length is "+2*a);
         }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        sequence(arr);

    }
}
