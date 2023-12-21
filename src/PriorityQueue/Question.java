package PriorityQueue;

import Heap.Heapify;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question {

    static int kthSmallestElement(ArrayList<Integer> arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // max heap

        //T.C = O(NLogk2)

        for(int i=0; i<arr.size(); i++){
            if(pq.size()==k) {
                if(arr.get(i)<pq.peek()){
                    pq.remove();
                    pq.add(arr.get(i));
                }else continue;
            }else pq.add(arr.get(i));
        }
        return pq.peek();
    }

    static int kthLargestElement(ArrayList<Integer> arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap




        for(int i=0; i<arr.size(); i++){
            if(pq.size()==k) {
                if(arr.get(i)>pq.peek()){
                    pq.remove();
                    pq.add(arr.get(i));
                }else continue;
            }else pq.add(arr.get(i));
        }
        return pq.peek();
    }

    static double distance(int arr[]){
        int a = arr[0];
        int b = arr[1];

        return Math.sqrt(a*a+b*b);
    }

    public static class point{
        int x;
        int y;
        double dist;

        point(int x, int y, double dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static class pointcompare implements Comparator<point>{
        public int compare(point p1, point p2){
            if(p1.dist<p2.dist) return 1;
            else if(p1.dist>p2.dist) return -1;
            else return 0;
        }
    }

    static int[][] kthSmallestDistanceFromOrigin(int arr[][], int k){

        PriorityQueue<point> pq = new PriorityQueue(new pointcompare());  // max heap

        for(int i=0; i<arr.length; i++){
            point p = new point(arr[i][0],arr[i][1],distance(arr[i]));
            if(pq.size()==k){
                if(p.dist<pq.peek().dist){
                    pq.remove();
                    pq.add(p);
                }else continue;
            }else pq.add(p);
        }

        int ans[][] = new int[pq.size()][2];
        int idx = 0;

        for(var a : pq){
            ans[idx][0] = a.x;
            ans[idx][1] = a.y;
            idx++;
        }
        return ans;
    }
    static int remove2smallestMultifyItAdDoThisKTimesReturnLargest(ArrayList<Integer> arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr);  //T.C = O(n)


        for(int i=1; i<=k; i++){  // T.C = k*logN
            int a = pq.remove();
            int b = pq.remove();

            int prod = a*b;

            pq.add(prod);
        }

        while(pq.size()!=1) pq.remove();  // (n-k)*logN

        return pq.peek();

    }

    static int sumOfElementBetweenK1AndK2SmallestElement(ArrayList<Integer> arr, int k1, int k2){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  // max heap;


        for(int i=0; i<arr.size(); i++){

            if(pq.size()==k2){
                if(arr.get(i)<pq.peek()){
                    pq.remove();
                    pq.add(arr.get(i));
                }else continue;
            }else{
                pq.add(arr.get(i));
            }
        }

        int ans = 0;

        pq.remove();

        while(pq.size()!=k1){
            ans+=pq.remove();
        }

        return ans;
    }
    public static void main(String[] args) {

        ArrayList<Integer> arr1 = new ArrayList<>();

        arr1.add(20);
        arr1.add(8);
        arr1.add(22);
        arr1.add(4);
        arr1.add(12);
        arr1.add(10);
        arr1.add(14);
//        arr1.add(30);
//
//        System.out.println(arr1);


        System.out.println(sumOfElementBetweenK1AndK2SmallestElement(arr1,3,6));
    }
}
