package Stacks;

import java.util.Stack;



public class BasicOfStacks {

    static void print(Stack<Integer> st){
        int n = st.size();
        if(n==0) return;

        int a = st.peek();
        st.pop();

        print(st);
        System.out.print(a+" ");
        return;
    }

    static int getFirstElement(Stack<Integer> st){
        int n = st.size();
        while(st.size()>1){
            st.pop();
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();


//        System.out.println(st.isEmpty());



        st.push(3);
        st.push(9);
        st.push(4);
        st.push(7);

       print(st);





    }
}
