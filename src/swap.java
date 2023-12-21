import java.util.Scanner;

class Reverse{
    public void Array(int[] arr, int st, int end){
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
    }


public class swap{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();
        int x=arr.length;


        Print obj2 = new Print();
        obj2.Array(arr);
    }
}
