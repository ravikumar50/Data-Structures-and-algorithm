import java.util.Scanner;
class question{
    static int greater(int[] arr, int x){
        int ans=0;
        for(int n=0; n<arr.length;n++){
            if(arr[n]>x)
                ans++;
        }
        return ans;
    }
}

public class QuestionArray2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int a = sc.nextInt();

        int[] arr = new int[a];
        System.out.println("Enter " + a + " elements of array");

        for (int n = 0; n < arr.length; n++) {
            arr[n] = sc.nextInt();
        }
        System.out.println("Enter the number");
        int x=sc.nextInt();
//        int ans=-1;
//        for (int n=0; n<arr.length; n++){
//            if(arr[n]==x);
//            ans=n;
//            break;
//        }
        question obj = new question();

        System.out.println("There are "+obj.greater(arr,x)+" elements that are greater than "+x);

    }
}

