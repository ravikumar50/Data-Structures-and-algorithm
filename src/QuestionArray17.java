import java.util.Scanner;

class Count{
    public int count(int[] arr, int a){

        int x = arr.length;
        int ans=0;

        for(int i=0; i<x; i++){
            if(arr[i]==a)
                ans++;
        }
        return ans;
    }
}

public class QuestionArray17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();

        System.out.println("Enter the number which do you want to count");
        int a = sc.nextInt();

        Count obj2 = new Count();

        System.out.println("The element "+a+" is found "+obj2.count(arr,a)+" times");

    }
}
