package Heap;

import java.util.ArrayList;

public class Deletion {

    static void swap(ArrayList<Integer> arr, int a, int b){

        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
    }

    static void deletionInMinHeap(ArrayList<Integer> heap){
        int n = heap.size();

        swap(heap,0,heap.size()-1);

        heap.remove(n-1);

        pushDownInMinHeap(heap,0,n);
    }

    static void pushDownInMinHeap(ArrayList<Integer> heap , int idx, int n){


        if(idx>=n) return;

        int left = 2*idx+1;
        int right = 2*idx+2;
        int small = idx;

        // finding smallest

        if(left<n && heap.get(left)<heap.get(small)) small = left;
        if(right<n && heap.get(right)<heap.get(small)) small = right;

        if(small == idx) return;

        swap(heap,idx,small);

        pushDownInMinHeap(heap,small,n);
    }

    static void deletionInMaxHeap(ArrayList<Integer> heap){
        int n = heap.size();

        swap(heap,0,n-1);
        heap.remove(n-1);

        pushDownInMaxHeap(heap,0,n);
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


    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<>();

//        heap.add(5);
//        heap.add(20);
//        heap.add(10);
//        heap.add(40);
//        heap.add(50);
//        heap.add(30);
//        heap.add(60);

        heap.add(60);
        heap.add(50);
        heap.add(40);
        heap.add(30);
        heap.add(20);
        heap.add(30);
        heap.add(10);

        /*
        1. Swap 1st and Last
        2. Delete Last
        3. Push Down till correct Position
        4. Swap with the minimum of its child
         */

        System.out.println(heap);
        deletionInMaxHeap(heap);
        System.out.println(heap);
    }
}
