package Heap;

import java.util.ArrayList;

public class Insertion {

    static void insertionInMinHeap(ArrayList<Integer> heap , int a){
        heap.add(a);                 // T.C = O(Height) = O(log(n))
                                     // S.C = O(1)
        int i = heap.size()-1;

        while(i!=0 && heap.get(i)<heap.get((i-1)/2)) {
            int x = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, x);
            i = (i - 1) / 2;
        }
    }

    static void insertionInMinHeapUsingRecursion(ArrayList<Integer> heap,int idx){

        int parentIdx = (idx-1)/2;

        if(idx==0 || heap.get(parentIdx)<heap.get(idx)) return;

        int temp = heap.get(idx);
        heap.set(idx,heap.get(parentIdx));
        heap.set(parentIdx,temp);

        insertionInMinHeapUsingRecursion(heap,parentIdx);
    }

    static void insertionInMaxHeap(ArrayList<Integer> heap, int a){

        heap.add(a);             // T.C = O(Height) = O(log(n))
                                 // S.C = O(1)
        int i=heap.size()-1;

        while(i!=0 && heap.get(i)>heap.get((i-1)/2)){

            int x = heap.get(i);
            heap.set(i,heap.get((i-1)/2));
            heap.set((i-1)/2,x);
            i = (i-1)/2;
        }
    }


    static void insertionInMaxHeapUsingRecursion(ArrayList<Integer> heap,int idx){

        int parentIdx = (idx-1)/2;

        if(idx==0 || heap.get(parentIdx)>heap.get(idx)) return;

        int temp = heap.get(idx);
        heap.set(idx,heap.get(parentIdx));
        heap.set(parentIdx,temp);

        insertionInMaxHeapUsingRecursion(heap,parentIdx);
    }


    public static void main(String[] args) {

        ArrayList<Integer> heap = new ArrayList<>();

        heap.add(60);
        heap.add(50);
        heap.add(40);
        heap.add(30);
        heap.add(20);
        heap.add(30);
        heap.add(10);

        System.out.println(heap);

        /*
        Steps Of Insertion

        1. Insert At Last.
        2. New Node ko thikhane lagao // Push Up/Shift Up/Heapify Up

           * Compare with parent and swap until correct position is not found
         */

        insertionInMaxHeap(heap,40);
        System.out.println(heap);
    }
}
