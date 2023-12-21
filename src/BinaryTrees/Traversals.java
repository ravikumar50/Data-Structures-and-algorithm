package BinaryTrees;

import java.net.InterfaceAddress;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Traversals {
    static class Node {
        int data;
        Node rgt;
        Node left;

        Node(int data) {
            this.data = data;
        }
    }

    static void preInPost(int n){
        if(n==0) return;          // Euler's Tree

        System.out.print(n);
        preInPost(n-1);
        System.out.print(n);
        preInPost(n-1);
        System.out.print(n);

    }

    static void preOrderTraversal(Node root){    // Root Left Right
        if(root==null) return;

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.rgt);
    }

    static void inOrderTraversal(Node root){     // Left Root Right
        if(root==null) return;

        inOrderTraversal(root.left);        // T.C = O(n)
        System.out.print(root.data+" ");    // S.C = best = O(logn) and worst = O(n)
        inOrderTraversal(root.rgt);         // for all traversal;
                               // S.C = O(height of tree)
    }

    static void postOrderTraversal(Node root){     // Left Right Root
        if(root==null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.rgt);
        System.out.print(root.data+" ");
    }

    static void printNthLevel(Node root, int n){
        if(n==1){
            System.out.print(root.data+" ");
            return;
        }
        if(root.left!=null) printNthLevel(root.left,n-1);
        if(root.rgt!=null) printNthLevel(root.rgt,n-1);

    }
    static int numberOfLevels(Node root){
        if(root==null) return 0;

        int a = numberOfLevels(root.left);
        int b = numberOfLevels(root.rgt);

        return 1+Math.max(a,b);
    }

    static void printingLevelWise(Node root){

        int n = numberOfLevels(root);

        for(int i=1; i<=n; i++){
            printNthLevel(root,i);
            System.out.println();
        }
    }

    static void breadthFirstSearchBFS(Node root){

        Queue<Node> q = new LinkedList();
        if(root!=null) q.add(root);

        while(q.size()>0){
            Node temp = q.remove();
            System.out.print(temp.data+" ");
            if(temp.left!=null) q.add(temp.left);
            if(temp.rgt!=null) q.add(temp.rgt);
        }
    }

    static void depthFirstSearchDFSInOrder(Node root){

        Stack<Node> st = new Stack<>();
        if(root!=null) st.push(root);

        while(st.size()>0){
            Node temp = st.peek();

            if(temp.left!=null){
                st.push(temp.left);
                temp.left=null;
            }else{
                st.pop();
                System.out.print(temp.data+" ");
                if(temp.rgt!=null) {
                    st.push(temp.rgt);

                }
            }
        }
    }

    static void depthFirstSearchDFSPreOrder(Node root){
        Stack<Node> st = new Stack<>();
        if(root==null) return;

        st.push(root);

        while(st.size()>0){
            Node temp = st.pop();
            if(temp.left!=null){
                System.out.print(temp.data+" ");
                if(temp.rgt!=null) st.push(temp.rgt);
                st.push(temp.left);
            }else{
                System.out.print(temp.data+" ");
                if(temp.rgt!=null) st.push(temp.rgt);
            }
        }
    }

    static void depthFirstSearchDFSPostOrder(Node root){

        if(root==null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(st.size()>0) {
            Node temp = st.peek();
            if(temp.left != null) {
                st.push(temp.left);
                temp.left = null;
            }else if(temp.rgt!=null){
                st.push(temp.rgt);
                temp.rgt=null;
            }else {
                st.pop();
                System.out.print(temp.data + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        Node f = new Node(7);
        b.left=e;
        b.rgt=f;

        Node t = a;

        printingLevelWise(a);

        System.out.println();

        t.left.data=8;
        printingLevelWise(a);


    }
}
