import java.awt.print.PrinterAbortException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class BucketSort {

    static void bucketSort(float arr[]) {
        int n = arr.length;

        ArrayList<Float>[] bucket = new ArrayList[n];
        //create empty bucket

        for(int i=0; i<n; i++){
            bucket[i]= new ArrayList<Float>();
        }
        // add elements to bucket
        for(int i=0; i<n; i++){
            int idx = (int) arr[i]*10;
            bucket[idx].add(arr[i]);
        }

        // sort each bucket;
         for(int i=0; i< bucket.length; i++){
             Collections.sort(bucket[i]);
         }

         //adding sorted elements to the array
        int idx=0;
        for(int i=0; i<n; i++){
            ArrayList<Float> currentBucket = bucket[i];
            for(int j=0; j<currentBucket.size(); j++){
                arr[idx++]=currentBucket.get(j);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        float arr[] = new float[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextFloat();
        }

        bucketSort(arr);

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
