package Queue;

import LinkedList.CirculerLinkedList;

public class LimkedListmplemationOfCircularQueue {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public static class queue{
        Node head = null;
        Node tail = null;
        int size = 0;

        void add(int a){
            Node t = new Node(a);
            if(head==null){
                head=t;
                tail=t;
                tail.next=head;
            }else{
                tail.next=t;
                tail=t;
                tail.next=head;
            }
            size++;
        }

        int peek(){
            return head.data;
        }

        int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            int a = head.data;
            head=head.next;
            tail.next=head;
            size--;
            return a;
        }

        void print(){
            Node t=head.next;
            System.out.print(head.data+" ");

            if(head.next==head){
                return;
            }else{
                while(t!=head){
                    System.out.print(t.data+" ");
                    t=t.next;
                }
                System.out.println();
            }
        }

    }
    public static void main(String[] args) {
        queue q = new queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        q.print();
        q.remove();
        q.print();
        System.out.println(q.size);
        System.out.println(q.peek());
    }
}
