import java.util.Scanner;

public class SelectionSort {

    static void selectionSort(int[] arr){     //by finding minimum element
        int n=arr.length;

        for(int i=0; i<n-1; i++){
            int min=i;
            for(int j=i+1; j<n; j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int x = arr[i];
            arr[i]=arr[min];
            arr[min]=x;
        }
    }

    static void selectionSort2(int[] arr) {    // by finding maximum element
        int n = arr.length;
        for (int i = n-1; i>=1; i--){
            int max = i;
            for(int j=0; j<i; j++){
                if(arr[max]<arr[j]){
                    max=j;
                }
            }
            int x = arr[i];
            arr[i]=arr[max];
            arr[max]=x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of Array");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements of Array");

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        selectionSort(arr);

        System.out.println("After Sorting");

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }


    }
}
