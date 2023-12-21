import java.util.Scanner;

public class QuestionArray27 {

    static void unique(int[] arr, int m){
        int x= arr.length;

        int[] freq =new int[100000];
        for(int i=0; i<x; i++){
            freq[arr[i]]+=1;
                }
        int count=0;
        for(int i=0; i<100000; i++){
            if(freq[i]==1){
                count++;
            }
        }

        if(count>=m){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
            }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter the number");
        int m= sc.nextInt();

        unique(arr,m);

    }
}
