import java.util.Scanner;

public class QuestionArray29 {


    static void querysum(int[] arr, int q){
        Scanner sc = new Scanner(System.in);
        int n=arr.length;



        for(int i=1; i<=q; i++){
            System.out.println("Enter the range");
            int l = sc.nextInt();
            int r = sc.nextInt();

            Prefix obj = new Prefix();
            int[] ans = obj.Array(arr);

            int sum = ans[r]-ans[l-1];

            System.out.println("Required sum is "+sum);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int x = sc.nextInt();

        int[] arr = new int[x+1];

        System.out.println("Enter "+x+" elements of array");

        for(int i=1; i<=x; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of Queries do you want");
        int q=sc.nextInt();

        querysum(arr,q);
    }
}
