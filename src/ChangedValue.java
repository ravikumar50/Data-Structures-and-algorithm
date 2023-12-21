import java.util.Arrays;

public class ChangedValue {


    static void printarray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        } System.out.println();
    }

//    static void ChangedValue(int[] arr){
//        for(int i=0; i<arr.length; i++){
//            arr[i]=0;
//        }
//    }


    public static void main(String[] args) {
        int [] arr = new int[4];

        arr[0]=2;
        arr[1]=4;
        arr[2]=1;
        arr[3]=9;

//        ChangedValue(arr);
      printarray(arr);

//        int [] arr2 = Arrays.copyOf(arr, arr.length);
//        printarray(arr2);
    }
}
