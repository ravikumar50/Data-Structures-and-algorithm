package Heap;

import java.util.ArrayList;

public class Question {

    static void swap(ArrayList<Integer> arr, int a, int b){

        int t = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,t);
    }



    static void heapifyToMaxHeap(ArrayList<Integer> arr){
        int n = arr.size();

        int firstNonLeafNode = (n-1-1)/2;

        for(int i=firstNonLeafNode; i>=0; i--){
            pushDowmInMaxHeap(arr,i,n);
        }
    }

    static void pushDowmInMaxHeap(ArrayList<Integer> arr, int idx, int n){
        if(idx>=n) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int large = idx;

        if(left<n && arr.get(left)>arr.get(large)) large = left;
        if(right<n && arr.get(right)>arr.get(large)) large = right;

        if(large==idx) return;

        swap(arr,idx,large);

        pushDowmInMaxHeap(arr,large,n);
    }

    static void heapifyToMinHeap(ArrayList<Integer> arr){
        int n = arr.size();

        int firstNonLeafNode = (n-1-1)/2;

        for(int i=firstNonLeafNode; i>=0; i--){
            pushDowmInMinHeap(arr,i,n);
        }
    }

    static void pushDowmInMinHeap(ArrayList<Integer> arr, int idx, int n){
        if(idx>=n) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int small = idx;

        if(left<n && arr.get(left)<arr.get(small)) small = left;
        if(right<n && arr.get(right)<arr.get(small)) small = right;

        if(small==idx) return;

        swap(arr,idx,small);

        pushDowmInMinHeap(arr,small,n);
    }



    static void minHeapToMaxHeap(ArrayList<Integer> arr){
        heapifyToMaxHeap(arr);
    }

    static void maxHeapToMinHeap(ArrayList<Integer> arr){
        heapifyToMinHeap(arr);
    }

    static ArrayList<Integer> mergingTwoMaxHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<arr1.size(); i++){
            arr.add(arr1.get(i));
        }

        for(int i=0; i<arr2.size(); i++){
            arr.add(arr2.get(i));
        }

        heapifyToMaxHeap(arr);
        return arr;
    }

    static ArrayList<Integer> mergingTwoMinHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<arr1.size(); i++){
            arr.add(arr1.get(i));
        }

        for(int i=0; i<arr2.size(); i++){
            arr.add(arr2.get(i));
        }

        heapifyToMinHeap(arr);
        return arr;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();

        arr1.add(3);
        arr1.add(33);
        arr1.add(32);
        arr1.add(1);
        arr1.add(65);
        arr1.add(21);
        arr1.add(63);
        arr1.add(30);

        ArrayList<Integer> arr2 = new ArrayList<>();

        arr2.add(60);
        arr2.add(50);
        arr2.add(40);
        arr2.add(30);
        arr2.add(20);
        arr2.add(30);
        arr2.add(10);


        heapifyToMaxHeap(arr1);
        heapifyToMaxHeap(arr2);


        System.out.println(arr1);
        System.out.println(arr2);


    }
}
