package LinkedList;

public class DoublyLinkedListClass {

    public static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
        }
    }

    public static class LinkedListDD{
        Node head=null;
        Node tail=null;
        int size=0;


        int getAtUsingHead(Node head, int idx){
            Node t = head;
            int ans=-1;
            if(idx<0 || idx>size-1) {
                System.out.println("Wrong Index");
            }else{
                for(int i=1; i<=idx; i++){
                    t=t.next;
                }
                ans = t.data;
            }

            return ans;
        }

        int getAt(int idx){
            Node t = head;
            int ans=-1;
            if(idx<0 || idx>size-1) {
                System.out.println("Wrong Index");
            }else{
                for(int i=1; i<=idx; i++){
                    t=t.next;
                }
                ans = t.data;
            }

            return ans;
        }
        void addAthead(int data) {
            Node t = new Node(data);

            if (head == null) {
                head = t;
                tail = t;
            }else {
                t.next = head;
                head.prev=t;


                head=t;
            }
            size++;
        }

        void addAttail(int data){
            Node t = new Node(data);

            if(head==null){
                addAthead(data);
            }else{
                tail.next=t;
                t.prev=tail;

                tail=t;
                size++;
            }
        }

        void add(int data, int idx){

            if(idx<0 || idx>size){
                System.out.println("Wrong Index");
                return;
            }
            if(idx==0){
                addAthead(data);
            }else if(idx==size+1) {
                addAttail(data);
            }else{
                Node t = new Node(data);
                Node temp=head;
               for(int i=1; i<idx; i++){
                   temp=temp.next;
               }
               if(temp.next==null){
                   temp.next=t;
                   t.prev=temp;
                   tail=t;
                   size++;
                   return;
               }
               Node k = temp.next;

               temp.next=t;
               t.prev=temp;

               t.next=k;
               k.prev=t;
            }
            size++;
        }

        void delete(int idx){
            if(idx<0 || idx>=size){
                System.out.print("Wrong Index");
                return;
            }
            if(idx==0){
                head=head.next;
                head.prev=null;
            }else if(idx==size-1){
                tail=tail.prev;
                tail.next=null;
            }else{
                Node t=head;
                for(int i=1; i<=idx; i++){
                    t=t.next;
                }
                Node k=t.next;
                Node l=t.prev;
                l.next=k;
                k.prev=l;
            }
            size--;

        }
        void displayForwardUsingNode(Node N){
            Node t=N;

            while(t.prev!=null){
                t=t.prev;
            }
            while(t!=null){
                System.out.print(t.data+" ");
                t=t.next;
            }
            System.out.println();
        }

        void displayBackwrdUisngNode(Node N){
            Node t=N;

            while(t.next!=null){
                t=t.next;
            }
            while(t!=null){
                System.out.print(t.data+" ");
                t=t.prev;
            }
            System.out.println();
        }

        void displayForward(){
            Node t=head;

        while(t!=null){
            System.out.print(t.data+" ");
            t=t.next;
        }
            System.out.println();
        }


        void displayBackwarkd(){
            Node t=tail;

            while(t!=null){
                System.out.print(t.data+" ");
                t=t.prev;
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
//        Node a = new Node(4);
//        Node b = new Node(3);
//        Node c = new Node(5);
//        Node d = new Node(8);
//        Node e = new Node(1);
//
//        a.next=b;
//        b.prev=a;
//
//        b.next=c;
//        c.prev=b;
//        c.next=d;
//        d.prev=c;
//
//        d.next=e;
//        e.prev=d;
//
        LinkedListDD dll = new LinkedListDD();

        dll.addAthead(4);
        dll.addAthead(3);
        dll.addAthead(1);
        dll.addAttail(5);
        dll.addAttail(7);
        dll.displayForward();

        System.out.println(dll.getAt(4));
    }
}
