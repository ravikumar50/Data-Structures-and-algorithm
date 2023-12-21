package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicOfQueue {

    static void print(Queue<Integer> q){
        int n = q.size();

        for(int i=0; i<n; i++){
            int a = q.remove();
            System.out.print(a+" ");
            q.add(a);
        }
    }

static void reversePrint(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> val = new Stack<>();

        while(q.size()>0){
            st.push(q.remove());
        }
        while(st.size()>0){
            int a = st.pop();
            System.out.print(a+" ");
            val.push(a);
        }

        while(val.size()>0){
            q.add(val.pop());
        }
}

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q);
//        q.remove();   // you can also use q.poll() to remove the element
//        int a = q.peek();  // or q.element();
//        int n = q.size();
//        System.out.println(n);
        reversePrint(q);
        System.out.println();
        print(q);
    }
}
