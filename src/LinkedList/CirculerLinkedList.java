package LinkedList;

public class CirculerLinkedList {

    public static class Node{
        int data;
        Node next;
        int size=0;

        public Node(int data){
            this.data=data;
        }
    }

    public static class LinkedListCC{
        Node head=null;
        Node tail=null;
        int size =0;

        void display(){
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


        void displayUsingNode(Node N){
            Node t=N.next;

            System.out.print(N.data+" ");

            while(t!=N){
                System.out.print(t.data+" ");
                t=t.next;
            }
            System.out.println();
        }

        void add(int x){
            Node t = new Node(x);
            if(head==null){
                head=t;
                tail=t;
                head.next=null;
                tail.next=null;
            }else if(head.next==null){
                tail=t;
                tail.next=head;
                head.next=tail;
            }else{
                t.next=head.next;
                head.next=t;
            }
            size++;
        }
        void delete(int x) {
            Node t = head;

            if (x == head.data) {
                tail.next = head.next;
                head = tail.next;
            } else {
                while (t.next.data != x) {
                    t = t.next;
                }
                t.next = t.next.next;
            }
            size--;
        }
    }

    public static void main(String[] args) {
//        Node a = new Node(4);
//        Node b = new Node(2);
//        Node c = new Node(8);
//        Node d = new Node(1);
//        Node e = new Node(9);
//
//
//        a.next=b;
//        b.next=c;
//        c.next=d;
//        d.next=e;
//        e.next=a;

        LinkedListCC cll = new LinkedListCC();

        cll.add(3);
        cll.add(8);
        cll.add(7);
        cll.add(5);
        cll.add(2);

        cll.display();
        cll.delete(3);
        cll.display();
        System.out.println(cll.size);
    }


}
