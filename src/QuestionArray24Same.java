import java.util.Scanner;

public class QuestionArray24Same {
    static void sort(int[] arr){
        int x=arr.length;

        int count=0;
        for(int i=0; i<x; i++){
            if(arr[i]==0){
                count++;
            }
        }
        for(int i=0; i<x; i++){
            if(i<count){
                arr[i]=0;
            } else {
                arr[i]=1;
            }
        }
        Print obj=new Print();
        obj.Array(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj2 = new NewArr();
        int[] arr = obj2.Array();

        sort(arr);
    }
}
