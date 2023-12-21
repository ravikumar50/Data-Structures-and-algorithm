package LinkedList;
import LinkedList.DoublyLinkedListClass.LinkedListDD;
import LinkedList.DoublyLinkedListClass.Node;

public class QuestionsOnDDLinkedList {

    static boolean pallindrome(Node head){
        Node t = head;

        while(t.next!=null){
            t=t.next;
        }

        Node h=head;

        while(h!=null){
            if(h.data!=t.data){
                return false;
            }
            h=h.next;
            t=t.prev;
        }

        return true;
    }

    static void targetSumInSortedList(Node head, int target){
        Node t=head;

        while(t.next!=null){
            t=t.next;
        }
        Node h=head;
        while(h.data<t.data){
            if(h.data+t.data==target){
                System.out.print(h.data+" and "+t.data);
                return;
            }else if(h.data+t.data>target){
                t=t.prev;
            }else if(h.data+t.data<target){
                h=h.next;
            }
        }
        System.out.println("Not Found");
    }

    static int criticlePointMaxima(Node head){
        Node t = head.next;
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;

        while(t.next.next!=null){
            if(t.data>t.prev.data && t.data>t.next.data) {
                if (t.data > max) max = t.data;
            }
            t=t.next;
        }

        return max;
    }

    static int criticlePointMainima(Node head) {
        Node t = head.next;
        int min = Integer.MAX_VALUE;

        while (t.next.next != null){
            if (t.data < t.prev.data && t.data < t.next.data) {
                if (t.data < min) min = t.data;
            }
            t = t.next;
        }
        return min;
    }

    public static void main(String[] args) {
        LinkedListDD dll = new LinkedListDD();

        Node a = new Node(1);
        Node b = new Node(5);
        Node c = new Node(2);
        Node d = new Node(7);
        Node e = new Node(1);
        Node f = new Node(7);

        a.next=b;
        b.prev=a;

        b.next=c;
        c.prev=b;

        c.next=d;
        d.prev=c;

        d.next=e;
        e.prev=d;

        e.next=f;
        f.prev=e;

        dll.displayForwardUsingNode(a);
        System.out.println(criticlePointMainima(a));
    }
}
