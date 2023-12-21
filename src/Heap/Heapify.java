package Heap;

import java.util.ArrayList;

public class Heapify {   // building a Heap

    /* using min heap
       insertion
       T.C = no.of nodes * t.c of one insertion
       T.C = n*logn

       Heapify - Push down each from 1st non leaf node untill the root node

       T.C = O(n)
     */

    static void swap(ArrayList<Integer> arr, int a, int b){

        int t = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,t);
    }

    static void heapifyBuildingAMinHeap(ArrayList<Integer> arr){
        int n = arr.size();
        int firstNonLeafNode = (n-1-1)/2;

        for(int i=firstNonLeafNode; i>=0; i--){
            pushDownInMinHeap(arr,i);
        }
    }

    static void pushDownInMinHeap(ArrayList<Integer> arr, int idx){
        int n = arr.size();
        if(idx>=n) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int small = idx;

        if(left<n && arr.get(left)<arr.get(small)) small = left;
        if(right<n && arr.get(right)<arr.get(small)) small = right;

        if(small==idx) return;

        swap(arr,idx,small);
        pushDownInMinHeap(arr,small);
    }

    static void heapifyBuildingAMaxHeap(ArrayList<Integer> arr){
        int n = arr.size();

        int firstNonLeafNode = (n-1-1)/2;

        for(int i=firstNonLeafNode; i>=0; i--){
            pushDownInMaxHeap(arr,i);
        }
    }

    static void pushDownInMaxHeap(ArrayList<Integer> arr, int idx){
        int n = arr.size();
        if(idx>=n) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int large = idx;

        if(left<n && arr.get(left)>arr.get(large)) large = left;
        if(right<n && arr.get(right)>arr.get(large)) large = right;

        if(large==idx) return;

        swap(arr,idx,large);

        pushDownInMaxHeap(arr,large);
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

        System.out.println(arr);

        heapifyBuildingAMaxHeap(arr);
        System.out.println(arr);
    }

}
