package BinarySearchTree;

import java.util.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
    }
}

public class Questions {



    static void display(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size()!=0){
            Node t = q.remove();
            System.out.print(t.data+" ");
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
    }

    static int level(Node root){
        if(root==null) return 0;
        int a = level(root.left);
        int b = level(root.right);

        return 1+Math.max(a,b);
    }

    static void printOneLevel(Node root,int n){
        if(root==null) return;
        if(n==1){
            System.out.print(root.data+" ");
        }
        printOneLevel(root.left,n-1);
        printOneLevel(root.right,n-1);
    }

    static void printLevelWise(Node root){
        int n = level(root);

        for(int i=1; i<=n; i++){
            printOneLevel(root,i);
            System.out.println();
        }
    }

    static void insertANodeInBinaryTree(Node root, int data){
        if(root==null) return;

        Node t = new Node(data);
        if(data>root.data){
            if(root.right==null){
                root.right=t;
                return;
            }else{
                insertANodeInBinaryTree(root.right,data);
            }
        }else{
            if(root.left==null){
                root.left=t;
                return;
            }else{
                insertANodeInBinaryTree(root.left,data);
            }
        }
    }

    static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }


    static Node arrayToBinarySearchTreeLevelOrderTraversal(int arr[]){

        if(arr[0]==-1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int n = arr.length;

        for(int i=1; i<n-1; i=i+2){
            Node t = q.remove();

            if(arr[i]!=-1){
                Node a = new Node(arr[i]);
                t.left=a;
                q.add(a);
            }
            if(arr[i+1]!=-1){
                Node a = new Node(arr[i+1]);
                t.right=a;
                q.add(a);
            }
        }
        return root;
    }

    static void deleteNodeHaving0Child(Node root, int data){
        if(root==null) return;

        if(data>root.data){
            if(root.right.data==data) root.right=null;
            else deleteNodeHaving0Child(root.right,data);
        }else{
            if(root.left.data==data) root.left=null;
            deleteNodeHaving0Child(root.left,data);
        }
    }

    static void deleteANode(Node root, int target){   // always pass the root with a fake Node
        if(root==null) return;

        if(root.data>target){  // go left
            Node l = root.left;
            if(l==null) return;
            if(l.data==target){
                if(l.left==null && l.right==null){   // leaf Node
                    root.left=null;
                }else if(l.left==null || l.right==null){
                    if(l.left!=null) root.left=l.left;  // only one child
                    else root.left=l.right;
                }else{                                   // two child
                    Node curr = l;
                    Node after = l.right;
                    while(after.left!=null) after=after.left;
                    deleteANode(root,after.data);

                    after.right=curr.right;
                    after.left=curr.left;
                    root.left=after;
                }
                return;
            }
            deleteANode(root.left,target);
        }


        if(root.data<target){  // go right
            Node r = root.right;
            if(r==null) return;
            if(r.data==target){
                if(r.left==null && r.right==null){   // leaf Node
                    root.right=null;
                }else if(r.left==null || r.right==null){
                    if(r.left!=null) root.right=r.right;  // only one child
                    else root.right=r.right;
                }else{
                    Node curr = r;
                    Node after = r.right;
                    while(after.left!=null) after=after.left;
                    deleteANode(root,after.data);

                    after.right=curr.right;
                    after.left=curr.left;
                    root.right=after;
                }
                return;
            }
            deleteANode(root.right,target);
        }
    }

    static int sum(Node root, int val){
        if(root==null) return 0;
        int ans = 0;
        if(root.data>=val) ans = ans+root.data;
        return ans+sum(root.right,val)+sum(root.left,val);
    }

    static void decreasingOrder(Node root){
        if(root==null) return;

        decreasingOrder(root.right);
        System.out.print(root.data+" ");
        decreasingOrder(root.left);
    }

    static void bstToGreaterTree(Node root,int prev[]){  // pass an array of one size and value =0

        if(root==null) return;

        bstToGreaterTree(root.right,prev);
        root.data+=prev[0];
        prev[0] = root.data;
        bstToGreaterTree(root.left,prev);
    }

    static void morrisTravelsalInorder(Node root){   // S.C = O(1);
                                                     // T.C = O(n);
        if(root==null) return;

        Node curr = root;

        while(curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;

                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }

                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }else{
                    pred.right=null;
                    System.out.print(curr.data+" ");
                    curr=curr.right;
                }

            }else{
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
        }
    }

    static void morrisTravelInorderDecresing(Node root){
        if(root==null) return;

        Node curr = root;

        while(curr!=null){
            if(curr.right!=null){
                Node succ = curr.right;
                while(succ.left!=null && succ.left!=curr){
                    succ=succ.left;
                }

                if(succ.left==null){
                    succ.left=curr;
                    curr=curr.right;
                }else{
                    succ.left=null;
                    System.out.print(curr.data+" ");
                    curr=curr.left;
                }
            }else{
                System.out.print(curr.data+" ");
                curr=curr.left;
            }
        }
    }

    static Node mirrorViewOfABinaryTree(Node root){
        if(root==null || (root.left==null && root.right==null)) return root;

        Node a = mirrorViewOfABinaryTree(root.left);
        Node b = mirrorViewOfABinaryTree(root.right);

        root.right=a;
        root.left=b;

        return root;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(10);
        Node a = new Node(5);
        Node b = new Node(15);
        Node c = new Node(3);
        Node d = new Node(8);
        Node e = new Node(12);
        Node f = new Node(20);

        root.left=a;
        root.right=b;

        a.left=c;
        a.right=d;

        b.left=e;
        b.right=f;

        printLevelWise(root);
        System.out.println();
        Node x = mirrorViewOfABinaryTree(root);

        int arr[] ={9,5,4,5,-1,2,6,2,5,-1,8,3,9,2,3,1,1,-1,
                4,5,4,2,2,6,4,-1,-1,1,7,-1,5,4,7,-1,
                -1,7,-1,1,5,6,1,-1,-1,-1,-1,9,2,
                -1,9,7,2,1,-1,-1,-1,6,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,5,-1,-1,3,
                -1,-1,-1,8,-1,1,-1,-1,8,-1,-1,
                -1,-1,2,-1,8,7};
        Node t = arrayToBinarySearchTreeLevelOrderTraversal(arr);

        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();




    }
}
