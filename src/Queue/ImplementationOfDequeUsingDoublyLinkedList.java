package Queue;

public class ImplementationOfDequeUsingDoublyLinkedList {

    public static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            next=null;
            prev=null;
        }
    }

    public static class deque {
        Node head = null;
        Node tail = null;
        int size = 0;

        void addlast(int a){
             Node t = new Node(a);
             if(head==null){
                 head=t;
                 tail=t;
                 tail.prev=head;
                 tail.next=null;
                 head.next=tail;
                 head.prev=null;
             }else{
                 t.prev=tail;
                 tail.next=t;
                 tail=t;
             }
             size++;
        }

        int peekfirst(){
            if(size==0){
                System.out.println("Deque is Empty");
                return -1;
            }

            return head.data;
        }

        int removefisrt(){
            if(size==0){
                System.out.println("Deque is Empty");
                return -1;
            }
            int a = head.data;
            head=head.next;
            head.prev=null;
            size--;
            return a;
        }

        void addfirst(int a){
            Node t = new Node(a);
            if(head==null){
                head=t;
                tail=t;
                head.next=tail;
                head.prev=null;
                tail.prev=head;
                tail.next=null;
            }else{
                t.next=head;
                head.prev=t;
                head=t;
            }
            size++;
        }

        int peekLast(){
            if(size==0){
                System.out.println("Deque is Empty");
                return -1;
            }
            return tail.data;
        }

        int removeLast(){
            if(size==0){
                System.out.println("Deque is Empty");
                return -1;
            }
            int a = tail.data;
            tail=tail.prev;
            tail.next=null;
            size--;
            return a;
        }

        void display(){
            if(size==0){
                System.out.println("Deque is Empty");
                return;
            }
            Node t = head;
            while(t!=null){
                System.out.print(t.data+" ");
                t=t.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
     deque dq = new deque();

        dq.addfirst(1);
        dq.addfirst(2);
        dq.addfirst(3);
        dq.addfirst(4);
        dq.display();

        dq.addlast(5);
        dq.addlast(6);
        dq.addlast(7);
        dq.addlast(8);
        dq.addlast(10);
        dq.display();
        dq.removefisrt();
        dq.display();
        dq.removeLast();
        dq.display();
        System.out.println(dq.peekfirst());
        System.out.println(dq.peekLast());
    }
}
