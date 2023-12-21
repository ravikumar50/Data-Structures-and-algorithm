package LinkedList;
import LinkedList.LinkedlistClass.Linkedlist;
import LinkedList.LinkedlistClass.Node;

import java.util.Stack;


public class QuestionOnLinkedlist {

    static void deleteUsingData(int data, Linkedlist ll) {
        Node x = ll.head;
        int idx = -1;
        for (int i = 0; i < ll.size; i++) {
            if (x.data == data) {
                idx = i;
                break;
            }
            x = x.next;
        }
        ll.deleteAt(idx);
    }

    static void deleteUsingNodeEasyMethod(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    static Node getNthnodeFromTheLast(int n, Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int idx = size - n;
        Node ans = head;
        if (idx < 0 || idx > size - 1) {
            return null;
        } else {
            for (int i = 1; i <= idx; i++) {
                ans = ans.next;
            }
        }
        return ans;
    }

    static Node getNthNodeFromLastBettetTC(int n, Node head) {

        Node slow = head;
        Node fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static Node deletingNthNodeFromLast(int n, Node head) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    static Node intersectionOfTwoLinkedlist(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node ans = null;
        int l1 = 0;
        int l2 = 0;
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }
        temp2 = head2;
        temp1 = head1;
        if (l1 > l2) {
            int n = l1 - l2;
            for (int i = 1; i <= n; i++) {
                temp1 = temp1.next;
            }
            while (temp2 != temp1) {
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
        } else {
            int n = l2 - l1;
            for (int i = 1; i <= n; i++) {
                temp2 = temp2.next;
            }
            while (temp1 != temp2) {
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
        }

        if (temp1 == null) return null;
        else return temp1;
    }

    static Node findingMiddleElement(Node head) {
        Node fast = head;
        Node slow = head;

        if (head.next == null) {
            return null;
        }


        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node deletingMiddleElement(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    static boolean cycleLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }


    static Node cycleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;  // if there is no cycle;
        Node temp = head;
        while (temp != slow) {
            slow = slow.next;
            temp = temp.next;
        }

        return temp;
    }

    static Node mergeTwoSortedLinkedList(Node head1, Node head2) {

        Node t1 = head1;
        Node t2 = head2;
        Node ans = new Node(1000);
        Node t = ans;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                t.next = t1;
                t = t.next;
                t1 = t1.next;
            } else {
                t.next = t2;
                t = t.next;
                t2 = t2.next;
            }
        }
        if (t1 == null) {
            t.next = t2;
        } else {
            t.next = t1;
        }

        return ans.next;
    }

    static Node FirstOddThenEven(Node head) {

        Node temp = head;
        Node ansO = new Node(1000);
        Node to = ansO;
        Node anse = new Node(10000);
        Node te = anse;

        while (temp != null) {
            if (temp.data % 2 != 0) {
                to.next = temp;
                to = to.next;
                temp = temp.next;
            } else {
                te.next = temp;
                te = te.next;
                temp = temp.next;
            }
        }
        ansO = ansO.next;
        anse = anse.next;
        if (te.next != null) te.next = null;
        to.next = anse;
        return ansO;
    }

    static Node removingAdjacentDuplicatesFromSortedList(Node head) {
        Node temp = head;
        Node ans = new Node(100);
        Node t = ans;

        while (temp != null && temp.next != null) {
            if (temp.data != temp.next.data) {
                temp = temp.next;
            }
            if (temp.next == null) {
                return head;
            }
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            }
        }
        return head;
    }

    static Node reverseALinkedList(Node head) {
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

    static Node reverseALinkedListUsingRecursion(Node head) {
        if (head.next == null) return head;

        Node ans = reverseALinkedListUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return ans;
    }

    static boolean pallindromeLinkedList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node t = reverseALinkedList(slow.next);
        slow.next = t;

        Node a = head;
        Node b = slow.next;
        while (b != null) {
            if (b.data != a.data) {
                return false;
            }
            b = b.next;
            a = a.next;
        }
        return true;
    }

    static int findDataAtIndex(Node head, int n) {
        Node t = head;
        int i = 0;
        while (i < n) {
            t = t.next;
            i++;
        }
        return t.data;
    }

    static int MaxTwinSum(Node head) {
        Node t = head;
        int size = 0;
        int ans = Integer.MIN_VALUE;
        while (t != null) {
            size++;
            t = t.next;
        }
        t = head;
        int i = 0;
        int j = size - 1;
        while (i < j) {
            int x = findDataAtIndex(head, i);
            int y = findDataAtIndex(head, j);
            if (x + y > ans) ans = x + y;
            i++;
            j--;
        }
        return ans;
    }

    static int MaxTwinSum2(Node head) {
        int ans = Integer.MIN_VALUE;

        Node t1 = head;
        Node slow = head;
        Node fast = head;

        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node t2 = reverseALinkedList(slow.next);
        slow.next = t2;

        while (t2 != null) {
            if (t1.data + t2.data > ans) ans = t1.data + t2.data;
            t1 = t1.next;
            t2 = t2.next;
        }
        return ans;
    }

    static Node oddEvenAlternate(Node head) {
        Node t = head;
        Node e = new Node(10000);
        Node o = new Node(10000);
        Node te = e;
        Node to = o;

        int i = 1;
        while (t != null) {
            if (i % 2 == 0) {
                te.next = t;
                te = te.next;
                t = t.next;
                i++;
            } else {
                to.next = t;
                to = to.next;
                t = t.next;
                i++;
            }
        }
        o = o.next;
        e = e.next;
        to.next = e;
        if (te.next != null) te.next = null;
        return o;
    }

    static Node deepCopyOfLinkedList(Node head) {
        Node temp = head;
        Node ans = new Node(-1);
        Node t = ans;
        while (temp != null) {
            Node a = new Node(temp.data);
            t.next = a;
            temp = temp.next;
            t = t.next;
        }
        return ans.next;
    }

    static Node copyWithRandomPointer(Node head) {

        Node t1 = head;
        Node t2 = deepCopyOfLinkedList(head);
        Node h = new Node(-1);
        Node t = h;

        while (t1 != null || t2 != null) {
            t.next = t1;
            t1 = t1.next;
            t = t.next;

            t.next = t2;
            t2 = t2.next;
            t = t.next;
        }
        return h.next;      // random pointer is left;
    }

    static Node addTwoLists(Node h1, Node h2) {


        Node t1=reverseALinkedList(h1);
        Node t2=reverseALinkedList(h2);
        Node sum=null;

        int carry=0;

        while(t1!=null || t2!=null || carry>0){

            int newdata=carry;
            if(t1!=null){
                newdata+=t1.data;
            }
            if(t2!=null){
                newdata+=t2.data;
            }
            carry=newdata/10;
            newdata=newdata%10;

            Node t = new Node(newdata);
            t.next=sum;
            sum=t;

            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;
        }

        return sum;
    }

    static Node intesectionOfTwoLinkedList(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;

        Node ans = new Node(-1);
        Node t = ans;

        while(t1!=null){
            while(t2!=null){
                if(t1.data==t2.data){
                    Node x = new Node(t1.data);
                    t.next=x;
                    t=t.next;
                }
                t2=t2.next;
            }
            t1=t1.next;
        }
        return ans.next;
    }

    static Node deleteEveryKthNode(Node head, int k) {
        if(k==1){
            return null;
        }

        int size=0;
        Node x = head;
        while(x!=null){
            x=x.next;
            size++;
        }

        Node ans = new Node(-1);
        ans.next=head;
        Node t = ans;

        int n = size/k;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k-1; j++){
                t=t.next;
            }
            t.next=t.next.next;
        }
        return head;
    }

    static int nodeToNum(linkedlist.Node head){


        linkedlist.Node t=head;

        int num=0;
        while(t!=null){
            num=num*10 + (t.data);
            t=t.next;
        }

        return num;

    }

    static int sumOfLinkedList(Node head1, Node head2){
        Node t1 = reverseALinkedList(head1);
        Node t2 = reverseALinkedList(head2);
        Stack<String> st = new Stack<>();
        int carry=0;
        while(t1!=null && t2!=null){
            int a = t1.data+t2.data+carry;
            carry=0;
            if(a>9){
                carry=(a/10);
                a=a%10;

            }
            if(st.size()==0) {
                st.push(String.valueOf(a));
            }else{
                String s = st.pop();
                st.push(String.valueOf(a)+s);
            }
            t1=t1.next;
            t2=t2.next;
        }

        while(t1!=null){
            int a = t1.data+carry;
            carry=0;
            if(a>9) {
                carry = a / 10;
                a=a%10;

                st.push(String.valueOf(a)+st.pop());
            }else{
                st.push(String.valueOf(a)+st.pop());
            }
            t1=t1.next;
        }

        while(t2!=null){
            int a = t2.data+carry;
            carry=0;
            if(a>9){
                carry = a / 10;
                a=a%10;
                st.push(String.valueOf(a)+st.pop());
            }else{
                st.push(String.valueOf(a)+st.pop());
            }
            t2=t2.next;
        }

        return Integer.valueOf(carry+st.pop());
    }

    static int subtractionOfLinkedList(Node head1, Node head2){

        Node t1 = reverseALinkedList(head1);
        Node t2 = reverseALinkedList(head2);

        Stack<String> st = new Stack<>();

        while(t1!=null && t2!=null){
            int a = t1.data;
            int b = t2.data;
            int sub=0;
            if(a>=b){
                sub=a-b;
            }else{
                a=a+10;
                sub=a-b;
                t1.next.data-=1;
            }

            if(st.size()==0) st.push(String.valueOf(sub));
            else{
                st.push(String.valueOf(sub)+st.pop());
            }

            t1=t1.next;
            t2=t2.next;
        }

        while(t1!=null){
            st.push(String.valueOf(t1.data)+st.pop());
            t1=t1.next;
        }

        while(t2!=null){
            st.push(String.valueOf(t2.data)+st.pop());
            t2=t2.next;
        }

        return Integer.valueOf(st.pop());
    }


    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
//        ll.addAtHead(2);
//        ll.add(1,3);
//        ll.add(2,1);
//        ll.add(3,4);
//        ll.add(4,8);
//        ll.add(5,7);
//        ll.addAttail(9);



        Node a = new Node(9);
        Node b = new Node(3);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(5);



        Node g = new Node(9);
        Node h = new Node(2);
        Node i = new Node(8);
        Node j = new Node(6);




        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        g.next=h;
        h.next=i;
        i.next=j;

        int ans = subtractionOfLinkedList(a,g);

        System.out.println(ans);



    }
}
