package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Basic {


    public static void main(String[] args) {
        PriorityQueue<Integer> arr = new PriorityQueue<>();  // By default it is a min heap
        PriorityQueue<Integer> arr2 = new PriorityQueue<>(Comparator.reverseOrder()); // max heap

        arr.add(10);
        arr.add(14);
        arr.add(5);
        arr.add(20);

        arr.remove(); // removes top element and return the top element

        System.out.println(arr.peek());

    }
}
