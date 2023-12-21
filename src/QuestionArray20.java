import java.util.Scanner;

class Print{
    public void Array(int[] arr){
        int x=arr.length;

        for(int i=0; i<x; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    }

public class QuestionArray20 {

    static void rotate(int[] arr, int k) {
        int x = arr.length;


        k = k % x;

//        int a,b,c;
//
//        for(int j=0; j<k; j++){
//            a=arr[x-1];
//            c=arr[0];
//            for(int i=0; i<x-1; i++){
//                b=arr[i+1];
//                arr[i+1]=c;
//                c=b;
//            }
//            arr[0]=a;
//        }

        int ans[] = new int[x];
        int j=0;

        for(int i=x-k; i<x; i++){
            ans[j]=arr[i];
            j++;
        }
        for(int i=0; i<x-k; i++){
            ans[j]=arr[i];
            j++;
        }

        Print obj = new Print();
        obj.Array(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        System.out.println("Enter number of times do you want to rotate");
        int k = sc.nextInt();

        System.out.println("Original Array");
        Print obj2 = new Print();
        obj2.Array(arr);

        System.out.println("Rotated Array");
        rotate(arr,k);


        }
    }
