import java.util.Arrays;


public class Arraycopy {


    static void printarray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        } System.out.println();
    }


    public static void main(String[] args) {
        int [] arr = new int[5];

        arr[0]=2;
        arr[1]=4;
        arr[2]=1;
        arr[3]=6;
        arr[4]=13;

        System.out.println("Original Array");
        printarray(arr);

        int [] arr2 = Arrays.copyOf(arr , 3);


        System.out.println("Coppied Array");
        printarray(arr2);

        int[] arr3 = arr2.clone();
        System.out.println("Final Copy");
        printarray(arr3);

        int [] arr4 = Arrays.copyOfRange(arr, 2,4);
        System.out.println("Coppied Range");
        printarray(arr4);
    }
}
