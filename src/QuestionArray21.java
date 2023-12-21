import java.util.Scanner;

public class QuestionArray21 {

    static void Query(int[] arr, int q){

        int x = arr.length;
        Scanner sc = new Scanner(System.in);
        int a=1;
        for(int j=0; j<q; j++){
            System.out.println("Enter the "+a+" number");
            int k = sc.nextInt();
            a++;

            int count=0;

            for(int i=0; i<x; i++){
                if(arr[i]==k){
                    System.out.println("Yes");
                    count++;
                }
                } if(count==0){
                System.out.println("No");
            }
            }
        }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter the number of Queries do you want to ask?");
        int q = sc.nextInt();

        Query(arr,q);

    }
}
