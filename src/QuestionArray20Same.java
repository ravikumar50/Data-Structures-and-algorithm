import java.util.Scanner;

public class QuestionArray20Same {

    static void reverse(int[] arr,int st, int end){
        int x=arr.length;

        int a;

        int i=st, j=end;
        while(i<j){
            a=arr[i];
            arr[i]=arr[j];
            arr[j]=a;
            i++; j--;
        }
    }

    static void finalrevere(int[] arr, int k){
        int x=arr.length;
        k=k%x;

          reverse(arr, 0, x-k-1);
          reverse(arr, x-k, x-1);
          reverse(arr, 0,x-1);

        Print obj = new Print();
        obj.Array(arr);
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter number of times do you want to rotate");
        int k = sc.nextInt();

        finalrevere(arr,k);
    }
}
