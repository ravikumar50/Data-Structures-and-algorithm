package Heap;

import java.util.ArrayList;

public class HeapSort {

    static void swap(ArrayList<Integer> arr, int a, int b){

        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
    }

    static void heapifyBuildingAMinHeap(ArrayList<Integer> arr){
        int n = arr.size();
        int firstNonLeafNode = (n-1-1)/2;

        for(int i=firstNonLeafNode; i>=0; i--){
            pushDownInMinHeap(arr,i,n);
        }
    }


    static void heapifyBuildingAMaxHeap(ArrayList<Integer> arr){
        int n = arr.size();

        int firstNonLeafNode = (n-1-1)/2;

        for(int i=firstNonLeafNode; i>=0; i--){
            pushDownInMaxHeap(arr,i,n);
        }
    }


    static void sortIncreasing(ArrayList<Integer> heap){
                                              // T.C = O(n+n*logn) = O(nlogn)
        heapifyBuildingAMaxHeap(heap);
        int n = heap.size();

        for(int i=n-1; i>0; i--){
            swap(heap,0,i);
            pushDownInMaxHeap(heap,0,i);  // push down upto i-1;
        }

    }

    static void pushDownInMaxHeap(ArrayList<Integer> heap, int idx, int n){

        if(idx>=n) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int large = idx;

        if(left<n && heap.get(left)>heap.get(large)) large = left;
        if(right<n && heap.get(right)>heap.get(large)) large = right;

        if(large==idx) return;

        swap(heap,idx,large);

        pushDownInMaxHeap(heap,large,n);
    }

    static void sortDecreasing(ArrayList<Integer> heap){
        heapifyBuildingAMinHeap(heap);
        int n = heap.size();

        for(int i=n-1; i>0; i--){
            swap(heap,0,i);
            pushDownInMinHeap(heap,0,i);  // push down upto i-1
        }
    }

    static void pushDownInMinHeap(ArrayList<Integer> heap, int idx, int x){

        if(idx>=x) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int small = idx;

        if(left<x && heap.get(left)<heap.get(small)) small = left;
        if(right<x && heap.get(right)<heap.get(small)) small = right;

        if(small==idx) return;

        swap(heap,idx,small);

        pushDownInMinHeap(heap,small,x);
    }
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(3);
        arr.add(33);
        arr.add(32);
        arr.add(1);
        arr.add(65);
        arr.add(21);
        arr.add(63);
        arr.add(30);

        sortIncreasing(arr);
        System.out.println(arr);
        sortDecreasing(arr);
        System.out.println(arr);
    }
}
