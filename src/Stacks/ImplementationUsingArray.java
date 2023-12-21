package Stacks;

import java.util.Scanner;

public class ImplementationUsingArray {

    static class Stack{
        private int[] arr = new int[50];
        private int idx = 0;

        void push(int x){
            if(isFull()){
                System.out.println("Stack is Full!");
                return;
            }
            arr[idx]=x;
            idx++;
        }

        int pop(){
            if(idx==0){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            idx--;
            int top = arr[idx];
            arr[idx]=0;
            return top;
        }

        int peek(){
            if(idx==0){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
          return arr[idx-1];
        }

        void display(){
            if(idx==0){
                System.out.print("Stack is empty");
                return;
            }
            for(int i=0; i<idx; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int size(){
          return idx;
        }

        boolean isEmpty(){
          if(idx==0) return true;
          else return false;
        }

        boolean isFull(){
         if(idx==arr.length)  return true;
         else return false;
        }

        int capacity(){
            return arr.length;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack st = new Stack();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
        System.out.println(st.peek());
        System.out.println(st.pop());
        st.display();



    }
}
