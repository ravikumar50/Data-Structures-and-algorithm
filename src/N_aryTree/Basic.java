package N_aryTree;

import java.util.*;

class Node{
    int data;
    ArrayList<Node> child;

    Node(int data){
        this.data = data;
        child = new ArrayList<>();
    }
}
public class Basic {

    static void formTree(Node root){
        root.child.add(new Node(5));
        root.child.add(new Node(11));
        root.child.add(new Node(63));

        Node a = root.child.get(0);
        Node b = root.child.get(1);
        Node c = root.child.get(2);

        a.child.add(new Node(1));
        a.child.add(new Node(4));
        a.child.add(new Node(8));

        b.child.add(new Node(6));
        b.child.add(new Node(7));
        b.child.add(new Node(15));

        c.child.add(new Node(31));
        c.child.add(new Node(53));
        c.child.add(new Node(65));



    }


    static void preOrderTraversal(Node root){  // root,left,right;
        if(root==null) return;

        System.out.print(root.data+" ");

        for(int i=0; i<root.child.size(); i++) {
            preOrderTraversal(root.child.get(i));
        }
    }

    static void postOrderTraversal(Node root){  // left,right,root;
        if(root==null) return;

        for(int i=0; i<root.child.size(); i++) {
            postOrderTraversal(root.child.get(i));
        }
        System.out.print(root.data+" ");
    }

    static int level(Node root){
        if(root==null) return 0;
        int maximum = 0;

        for(int i=0; i<root.child.size(); i++){
            maximum=Math.max(maximum,level(root.child.get(i)));
        }

        return maximum+1;
    }

    static void printOneLevel(Node root, int n){
        if(n==1){
            System.out.print(root.data+" ");
            return;
        }

        for(int i=0; i<root.child.size(); i++){
            printOneLevel(root.child.get(i),n-1);
        }
    }

    static void printLevelWise(Node root){
        int n = level(root);

        for(int i=1; i<=n; i++){
            printOneLevel(root,i);
            System.out.println();
        }
    }

    static void rightToLeft(Node root, int n){
        if(n==1){
            System.out.print(root.data+" ");
            return;
        }

        for(int i=root.child.size()-1; i>=0; i--){
            rightToLeft(root.child.get(i),n-1);
        }
    }

    static void leftToRight(Node root, int n){
        if(n==1){
            System.out.print(root.data+" ");
            return;
        }

        for(int i=0; i<root.child.size(); i++){
            leftToRight(root.child.get(i),n-1);
        }
    }

    static void zigzagLevelOrderTraversal(Node root){

        int n = level(root);

        for(int i=1; i<=n; i++){
            if(i%2==0){
                rightToLeft(root,i);
                System.out.println();
            }else{
                leftToRight(root,i);
                System.out.println();
            }
        }
    }

    static void breadthFirstSearchBFS(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(q.size()!=0){
            Node t = q.remove();
            System.out.print(t.data+" ");
            for(int i=0; i<t.child.size(); i++) {
                q.add(t.child.get(i));
            }
        }
    }

    static int maximumValue(Node root){
        if(root.child.size()==0) return root.data;

        int max = root.data;
        for(int i=0; i<root.child.size(); i++){
            max = Math.max(max,maximumValue(root.child.get(i)));
        }

        return Math.max(root.data,max);
    }

    static void mirrorViewOfATree(Node root){
        if(root==null) return;
        if(root.child.size()==1) return;

        int n = root.child.size();

        for(int i=0; i<n; i++){
            mirrorViewOfATree(root.child.get(i));
            reverseAList(root.child);
        }
    }

    static void reverseAList(ArrayList<Node> arr){
        int i=0;
        int j=arr.size()-1;

        while(i<j){
            Node a = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,a);
            i++;
            j--;
        }
    }


    public static void main(String[] args) {

        Node root = new Node(30);
        formTree(root);
        System.out.println(root.child.get(0));

        printLevelWise(root);
        mirrorViewOfATree(root);
        System.out.println();
        printLevelWise(root);


    }

}
