package Queue;

public class ImplementationUsingLinkedList {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }

    public class queue{
        Node head = null;
        Node tail = null;
        int size=0;

        void add(int a){
            Node t = new Node(a);

            if(head==null){
                head=t;
                tail=t;
            }else{
                tail.next=t;
                tail=t;
            }
            size++;

        }

        int peek(){
            if(size==0) {
                System.out.print("Queue is empty");
                return -1;
            }
            return head.data;
        }

        int remove(){
            if(size==0) {
                System.out.print("Queue is empty");
                return -1;
            }

            int a = head.data;
            head=head.next;
            size--;
            return a;
        }

        void print(){
            if(size==0) {
                System.out.print("Queue is empty");
                return;
            }
            Node t = head;
            while(t!=tail){
                System.out.print(t.data+" ");
            }
        }
    }
    public static void main(String[] args) {
     ImplementationUsingArray.queue q = new ImplementationUsingArray.queue();
        q.remove();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(488);
        q.add(5);
        q.add(6);

        q.print();
        q.remove();
        q.print();
        System.out.println(q.size);
        System.out.println(q.peek());
    }
}
