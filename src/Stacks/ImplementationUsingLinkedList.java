package Stacks;

import java.util.Scanner;

public class ImplementationUsingLinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

        public static class Stack{
           private Node head = null;
           private int size=0;

            void push(int x){
                Node temp = new Node(x);
                temp.next=head;
                head=temp;
                size++;
            }

            int pop(){
                if(head==null){
                    System.out.println("Stack is empty");
                    return Integer.MIN_VALUE;
                }
                int top = head.data;
                head=head.next;
                size--;
                return top;
            }

            int peek(){
                if(head==null){
                    System.out.println("Stack is empty");
                    return Integer.MIN_VALUE;
                }
                return head.data;
            }

            void displayRecursive(Node h){
                if(h==null) return;
                displayRecursive((h.next));
                System.out.print(h.data+" ");
                return;
            }

            void display(){
                if(head==null){
                    System.out.println("Stack is empty");
                }
                displayRecursive(head);
                System.out.println();
            }

            boolean isEmpty(){
                if(head==null) return true;
                else return false;
            }

            int size(){
                return size;
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
        System.out.println(st.size);
        System.out.println(st.peek());
        st.pop();
        st.display();
        System.out.println(st.size);
    }
}
