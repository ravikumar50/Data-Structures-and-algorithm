import java.util.Scanner;
 class NewArr {
    public int[] Array() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int a = sc.nextInt();

        int[] arr = new int[a];
        System.out.println("Enter " + a + " elements of array");

        for (int n = 0; n < a; n++) {
            arr[n] = sc.nextInt();
        }
        return arr;
    }
}


public class QuestionArray3 {
    public static void main(String[] args) {
        NewArr obj = new NewArr();
        int [] ans = obj.Array();

        boolean check = false;

        for(int n=0; n<ans.length-1; n++){
            if(ans[n]>=ans[n+1]){
                check = true;
                break;
            }

        }
        System.out.println(check);
    }
}

