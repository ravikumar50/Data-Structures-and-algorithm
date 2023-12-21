import BinaryTrees.Implementation;

import java.util.Stack;

class Node{
    int data;
    Node rgt;
    Node left;

    Node(int data){
        this.data=data;
    }
}

public class Hello {

    static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.rgt);
    }

    static void preOrderDFS(Node root){

        if(root==null) return;

        Stack<Node> st = new Stack<>();

        st.push(root);

        while(st.size()>0){
            Node t = st.pop();
            if(t.left!=null){
                System.out.print(t.data);
                if(t.rgt!=null) st.push(t.rgt);
                st.push(t.left);
            }else{
                System.out.print(t.data);
                if(t.rgt!=null) st.push(t.rgt);
            }
        }
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left=a;
        root.rgt=b;

        Node c = new Node(4);
        Node d = new Node(5);
        a.left=c;
        a.rgt=d;

        Node e = new Node(6);
        b.rgt=e;
        Node f = new Node(7);
        e.left=f;
        Node g = new Node(8);
        Node h = new Node(9);
        d.rgt=g;
        f.left=h;


        int x = 23423;

        String s = String.valueOf(x)+"->";

        System.out.println(s);


    }
}
