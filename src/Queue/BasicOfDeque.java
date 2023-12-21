package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class BasicOfDeque {
    public static void main(String[] args) {
        Deque dq = new LinkedList();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addFirst(4);
        System.out.println(dq);
        dq.addLast(5);
        dq.addLast(6);
        dq.addLast(7);
        dq.addLast(8);
        dq.add(10);
        System.out.println(dq);
        dq.removeFirst();
        System.out.println(dq);
        dq.removeLast();
        System.out.println(dq);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
    }
}
