package LinkedList;
import org.w3c.dom.Node;

import java.util.*;

public class linkedlist {

    static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    // printing data using recursive function call
    static void printrecursive(Node head){
        if(head==null) return;
        System.out.print(head.data+" ");
        printrecursive(head.next);
    }

    // finding the lenght of a linked list
    static int lenght(Node head){
        int lenght=0;
        Node temp = head;
        while(temp!=null){
            lenght++;
            temp=temp.next;
        }
        return lenght;
    }

    static void insertAtEnd(Node head, int val){
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node t = new Node(val);
        temp.next= t;


    }


    // finding the lenght of a linked list recursively

    static int lengthrecursive(Node head){
        if(head==null) return 0;

        return 1+lengthrecursive(head.next);
    }
        // Node class
        public static class Node{
            public int data;
            Node next;


            // CONSTRUCTER
            public Node(int data){
                this.data=data;
            }
        }



    static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node after = null;

        while (curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }

    static long linkeListTONumber(Node head){

        Node t = head;
        long num1=0;


        while(t!=null){
            num1=num1*10+t.data;
            t=t.next;
        }

        return num1;
    }

    static Node numbertTOLinkedList(long num){
        Node ans = new Node(-1);
        Node t = ans;
        if(num==0){
            t.next=new Node(0);
        }else {
            while (num != 0) {
                long r = num % 10;
                Node a = new Node((int)r);
                t.next = a;
                t = t.next;
                num = num / 10;
            }
        }

        return ans.next;
    }

    static int num(Node head1){


        Node t1=head1;

        int num1=0;
        while(t1!=null){
            num1=num1*10 + (t1.data);
            t1=t1.next;
        }

        return num1;

    }
    static void split(Node head) {
        Node o = head;
        Node e = head.next;
        Node te = e;
        Node to = o;

        while (te != null && te.next != null) {
            to.next = te.next;
            to = to.next;
            if (to == null) break;

            te.next = to.next;
            te = te.next;
        }

        if (to!= null) to.next = null;
        if (te!= null) te.next = null;

        Node t1 = o;
        Node t2 = e;

        while (t1 != null) {
            System.out.print(t1.data + " ");
            t1 = t1.next;
        }

        System.out.println();

        while (t2 != null) {
            System.out.print(t2.data + " ");
            t2 = t2.next;
        }
    }

        public static void main(String[] args) {

           Node a = new Node(9);
           Node b = new Node(9);
           Node c = new Node(9);
           Node d = new Node(9);
           Node e = new Node(9);
           Node f = new Node(9);
           Node g = new Node(9);
           Node h = new Node(9);
           Node i = new Node(9);
           Node j = new Node(1);

           a.next=b;
           b.next=c;
           c.next=d;
           d.next=e;
           e.next=f;
           f.next=g;
           g.next=h;
           h.next=i;
           i.next=j;
//            print(a);

            Node ans = numbertTOLinkedList(1234);
            print(ans);




    }
}
