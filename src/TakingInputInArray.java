import java.util.Scanner;
import java.util.Arrays;

public class TakingInputInArray {

    static void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the length of array");
//        int a = sc.nextInt();
//        int [] arr = new int[a];
//
//        System.out.println("Enter " + a + " elements of Array");
//
//        for(int n=0; n<arr.length; n++){
//            arr[n]=sc.nextInt();
//        }
        int[] arr = new int[5];

        arr[0] = 2;
        arr[1] = 6;
        arr[2] = 7;
        arr[3] = 1;
        arr[4] = 12;

        System.out.println("Original Array");
        printarray(arr);

//          int [] arr2 = arr;
        int[] arr2 = arr.clone();

        System.out.println("Coppied Array2");
        printarray(arr2);

        arr2[1] = 0;
        arr2[2] = 0;

        System.out.println("Original Array after changing Array2");
        printarray(arr);

        System.out.println("Coppied Array2 after changing Array2");
        printarray(arr2);



    }
}

