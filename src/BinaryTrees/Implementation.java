package BinaryTrees;

import java.util.Scanner;

public class Implementation {

    static class Node{
        int data;
        Node rgt;
        Node left;

        Node(int data){
            this.data=data;
        }
    }

    static void displayTree(Node root){

        if(root==null) return;

        System.out.print(root.data+" -> ");
        if(root.left!=null){
            System.out.print(root.left.data+", ");
        }else{
            System.out.print("Null, ");
        }

        if(root.rgt!=null){
            System.out.print(root.rgt.data+", ");
        }else{
            System.out.print("Null, ");
        }
        System.out.println();

        displayTree(root.left);
        displayTree(root.rgt);
    }

    static void preOrderTraversal(Node root){

        if(root==null) return;

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.rgt);
    }

    static int size(Node root){
        if(root==null) return 0;

        return 1+size(root.left)+size(root.rgt);
    }

    static int sum(Node root){
        if(root==null) return 0;

        return root.data+sum(root.left)+sum(root.rgt);
    }

    static int max(Node root){
        if(root==null) return Integer.MIN_VALUE;

        int a = max(root.left);
        int b = max(root.rgt);

        return Math.max(root.data, Math.max(a,b));
    }

    static int min(Node root){
        if(root==null) return Integer.MAX_VALUE;

        int a = min(root.left);
        int b = min(root.rgt);

        return Math.min(root.data, Math.min(a,b));
    }

    static int numberOfLevels(Node root){
        if(root==null) return 0;

        int a = numberOfLevels(root.left);
        int b = numberOfLevels(root.rgt);

        return 1+Math.max(a,b);
    }


    static int heightOfTree(Node root){
        if(root==null || (root.left==null && root.rgt==null)) return 0;

        return 1+Math.max(heightOfTree(root.left),heightOfTree(root.rgt));
    }

    static int prodectOfTree(Node root){
        if(root==null) return 1;

        return root.data*prodectOfTree(root.left)*prodectOfTree(root.rgt);
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
        b.rgt=e;
        Node f = new Node(7);
        e.left=f;

        int x = prodectOfTree(root);

        System.out.println(prodectOfTree(root));

    }
}
