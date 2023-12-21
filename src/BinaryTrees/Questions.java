package BinaryTrees;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.nio.charset.MalformedInputException;
import java.util.*;



class Node {
    int data;
    Node rgt;
    Node left;

    Node(int data) {
        this.data = data;
    }
}

public class Questions {

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


    static int height(Node root){
        if(root==null || (root.left==null && root.rgt==null)) return 0;

        return 1+Math.max(height(root.left),height(root.rgt));
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

    static void printingLevelWise(Node root){

        int n = numberOfLevels(root);

        for(int i=1; i<=n; i++){
            printNthLevelFromLeftToRight(root,i);
            System.out.println();
        }
    }

    static int diameterOfTree(Node root){
        if(root==null) return 0;
        if(root.left==null && root.rgt==null) return 1;

        int left = diameterOfTree(root.left);
        int rgt = diameterOfTree(root.rgt);
        int mid = height(root.rgt)+height(root.left);

        if(root.left!=null && root.rgt!=null) mid+=3;
        if(root.rgt==null && root.left!=null) mid+=2;
        if(root.rgt!=null && root.left==null) mid+=2;

        return Math.max(mid, Math.max(left,rgt));

    }

    static boolean balancedBinaryTree(Node root){
        if(root==null) return true;

        int h1 = height(root.left);
        if(root.left!=null) h1++;

        int h2 = height(root.rgt);
        if(root.rgt!=null) h2++;

        if(Math.abs(h2-h1)>1) return false;

        return balancedBinaryTree(root.left) && balancedBinaryTree(root.rgt);
    }
    static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;


        if (p != q) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.rgt, q.rgt);
    }
    static void binaryTreePath(Node root, ArrayList<String> ans, String s){
        if(root==null) return;
        if(root.left==null && root.rgt==null){
            s+=root.data;
            ans.add(s);
            return;
        }

        int a = root.data;
        String str = String.valueOf(a)+"->";

        binaryTreePath(root.rgt,ans,s+str);
        binaryTreePath(root.left,ans,s+str);
    }

    static void rootToNode(Node root, Node target, String s){
        if(root==null) return;
        if(root==target){
            System.out.println(s+root.data);
            return;
        }

        rootToNode(root.left,target,s+root.data);
        rootToNode(root.rgt,target,s+root.data);
    }

    static void rootToNode2(Node root, Node target, String s, ArrayList<String> arr){
        if(root==null) return;
        if(root==target){
            arr.add(s+root.data);
            return;
        }

        rootToNode2(root.left,target,s+root.data,arr);
        rootToNode2(root.rgt,target,s+root.data,arr);
    }

    static void rootToNode3(Node root, Node target, Node head, ArrayList<Node> arr){
        if(root==null) return;
        if(root==target){
            Node t = new Node(root.data);
            t.rgt=head;
            head=t;
            arr.add(head);
            return;
        }

        Node t = new Node(root.data);
        t.rgt=head;
        head=t;

        rootToNode3(root.left,target,head,arr);
        rootToNode3(root.rgt,target,head,arr);
    }

    static int leastCommonAncesstorLCS(Node root, Node p, Node q){
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();

        rootToNode2(root,p,"",s1);
        rootToNode2(root,q,"",s2);

        String a = s1.get(0);
        String b = s2.get(0);


        int n = Math.min(a.length(),b.length());
        int ans = -1;

        for(int i=0; i<n; i++){
            if(a.charAt(i)==b.charAt(i)){
                ans=(int)a.charAt(i);
                ans=ans-48;
            }
        }

        return ans;
    }

    static Node reverseANode(Node head) {

        Node curr = head;
        Node after = null;
        Node prev = null;

        while (curr != null) {
            after = curr.rgt;
            curr.rgt=prev;
            prev=curr;
            curr=after;
        }

        return prev;
    }

    static Node leastCommonAncesstorLCS2(Node root, Node p, Node q){

        ArrayList<Node> arr1 = new ArrayList<>();
        ArrayList<Node> arr2 = new ArrayList<>();

        rootToNode3(root,p,null,arr1);
        rootToNode3(root,q,null,arr2);

        Node head1 = reverseANode(arr1.get(0));
        Node head2 = reverseANode(arr2.get(0));

        Node ans = new Node(-1);

        Node t1 = head1;
        Node t2 = head2;

        while(t1!=null && t2!=null){
            if(t1==t2){
                ans=t1;
            }
            t1=t1.rgt;
            t2=t2.rgt;
        }
        return ans;
    }

    static boolean contains(Node root, Node target){
        if(root==null) return false;
        if(root==target) return true;

        return contains(root.left,target) || contains(root.rgt,target);
    }

    static Node leastCommonAncesstorLCDNode(Node root, Node p, Node q){
        if(p==root || q==root) return root;
        if(p==q) return p;

        boolean leftp = contains(root.left,p);
        boolean rightq = contains(root.rgt,q);


        if(leftp && !rightq) return leastCommonAncesstorLCDNode(root.left,p,q);
        else if(!leftp && rightq) return leastCommonAncesstorLCDNode(root.rgt,p,q);
        else return root;

    }

    static Node invertBinaryTree(Node root){
        if(root==null) return null;
        if(root.left==null && root.rgt==null) return root;

        Node rgt = invertBinaryTree(root.rgt);
        Node left = invertBinaryTree(root.left);

        root.left=rgt;
        root.rgt=left;

        return root;
    }

    static boolean symmetricTree(Node root){

        root.left = invertBinaryTree(root.left);

        return isSameTree(root.rgt,root.left);
    }

    static int numberOfLevels(Node root){
        if(root==null) return 0;

        int a = numberOfLevels(root.left);
        int b = numberOfLevels(root.rgt);

        return 1+Math.max(a,b);
    }

    static void printNthLevelFromLeftToRight(Node root, int n){
        if(n==1){
            System.out.print(root.data+" ");
            return;
        }
        if(root.left!=null) printNthLevelFromLeftToRight(root.left,n-1);
        if(root.rgt!=null) printNthLevelFromLeftToRight(root.rgt,n-1);

    }

    static void printNthLevelFromRightToLeft(Node root, int n){
        if(root==null) return;
        if(n==1){
            System.out.print(root.data+" ");
        }
        printNthLevelFromRightToLeft(root.rgt,n-1);
        printNthLevelFromRightToLeft(root.left,n-1);
    }

    static void ZigZag(Node root){
        int n = numberOfLevels(root);

        for(int i=1; i<=n; i++){
            if(i%2!=0) {
                printNthLevelFromLeftToRight(root, i);
            }else{
                printNthLevelFromRightToLeft(root,i);
            }
            System.out.println();
        }
    }


    static Node implementingTreeFromLevelOrderTraversalByBFS(int arr[]){
        if(arr[0]==-1) return null;
        int data = arr[0];

        Node root = new Node(data);
        int n = arr.length;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for(int i=1; i<n-1; i=i+2){
            Node top = q.remove();
            int a = Integer.MIN_VALUE;
            int b = Integer.MIN_VALUE;
            if(arr[i]!=-1){
                a = arr[i];
            }
            if(arr[i+1]!=-1){
                b = arr[i+1];
            }

            if(a!=Integer.MIN_VALUE){
                Node left = new Node(a);
                top.left = left;
                q.add(left);
            }

            if(b!=Integer.MIN_VALUE) {
                Node right = new Node(b);
                top.rgt = right;
                q.add(right);
            }
        }
        return root;
    }

    static void leftBoundaryPrint(Node root){
        if(root==null) return;
        if(root.left==null && root.rgt==null) return;

        System.out.print(root.data+" ");
        if(root.left!=null) leftBoundaryPrint(root.left);
        else leftBoundaryPrint(root.rgt);
    }

    static void rightBoundaryPrintFromBelow(Node root){
        if(root==null) return;
        if(root.rgt==null && root.left==null) return;

        if(root.rgt!=null) rightBoundaryPrintFromBelow(root.rgt);
        else rightBoundaryPrintFromBelow(root.left);
        System.out.print(root.data+" ");
    }

    static void leafNodePrint(Node root){
        if(root==null) return;
        if(root.left==null && root.rgt==null){
            System.out.print(root.data+" ");
        }

        leafNodePrint(root.left);
        leafNodePrint(root.rgt);
    }

    static void boundaryTraversal(Node root){
        if(root==null) return;

        System.out.print(root.data+" ");
        leftBoundaryPrint(root.left);
        leafNodePrint(root);
        rightBoundaryPrintFromBelow(root.rgt);
    }
    static void rightSideView(Node root, int n, int arr[]){  // pass n = 0;
        if(root==null) return;

        arr[n]=root.data;

        rightSideView(root.left,n+1,arr);
        rightSideView(root.rgt,n+1,arr);
    }

    static void leftSideView(Node root, int n , int arr[]){  // pass n = 0;
        if(root==null) return;

        arr[n]=root.data;
        leftSideView(root.rgt,n+1,arr);
        leftSideView(root.left,n+1,arr);
    }

    static int greaterSum(Node root, int a){
        int ans=0;
        if(root==null) return 0;
        if(root.data>=a) ans+=root.data;

        ans=ans+greaterSum(root.left,a)+greaterSum(root.rgt,a);
        return ans;
    }

    static int size(Node root){
        if(root==null) return 0;

        return 1+size(root.left)+size(root.rgt);
    }

    static void updateTreeByGreaterSum(Node root,ArrayList<Integer> arr){
        Queue<Node> q = new LinkedList();
        if(root!=null) q.add(root);

        while(q.size()>0){
            Node temp = q.remove();
            temp.data=arr.remove(0);
            if(temp.left!=null) q.add(temp.left);
            if(temp.rgt!=null) q.add(temp.rgt);
        }

    }

    static void binaryTreeToArray(Node root,ArrayList<Integer> arr){
        Queue<Node> q = new LinkedList();
        if(root!=null) q.add(root);

        while(q.size()>0){
            Node temp = q.remove();
            arr.add(temp.data);
            if(temp.left!=null) q.add(temp.left);
            if(temp.rgt!=null) q.add(temp.rgt);
        }
    }


    static boolean contains(Node root, int a){
        if(root==null) return false;
        if(root.data==a) return true;

        return contains(root.left,a) || contains(root.rgt,a);
    }

    static void helper(Node root1, Node root2, ArrayList<Integer> arr){
        if(root1==null) return;

        if(contains(root2,root1.data)) arr.add(root1.data);

        helper(root1.left,root2,arr);
        helper(root1.rgt,root2,arr);
    }

    static void NthLevelVerticlePrint(Node root,int level, int currLevel){
        if(root==null) return;

        if(currLevel==level){
            System.out.print(root.data+" ");
        }
        NthLevelVerticlePrint(root.left,level,currLevel-1);
        NthLevelVerticlePrint(root.rgt,level,currLevel+1);
    }

    static int leftCount(Node root){

        if(root==null) return 0;
        return 1+leftCount(root.left);
    }

    static int rightCount(Node root){

        if(root==null) return 0;
        return 1+rightCount(root.rgt);
    }

    static void topViewPrint(Node root, int level, int currLevel){
        if(root==null) return;
        if(currLevel==level){
            System.out.print(root.data+" ");
            return;
        }

        topViewPrint(root.left,level,currLevel-1);
        topViewPrint(root.rgt,level,currLevel+1);
    }

    static void bottomView(Node root, int idx, ArrayList<Integer> arr){   // here idx is the index of root that is starting from left
        if(root==null) return;

        arr.set(idx,root.data);
        bottomView(root.rgt,idx+1,arr);
        bottomView(root.left,idx-1,arr);
    }

    static void bottomViewUsingHashMap(Node root, int idx, HashMap<Integer,Integer> hp){
        if(root==null) return;   // here idx is the index of root that is starting from left

        if(hp.containsKey(idx)) {
            hp.remove(idx);
            hp.put(idx, root.data);
        }else{
            hp.put(idx,root.data);
        }


        bottomViewUsingHashMap(root.left,idx-1,hp);
        bottomViewUsingHashMap(root.rgt,idx+1,hp);
    }
    static void preOrder(Node root, ArrayList<Integer> pre){
        if(root==null) return;

        pre.add(root.data);

        preOrder(root.left,pre);
        preOrder(root.rgt,pre);
    }

    static void postOrder(Node root, ArrayList<Integer> arr){     // Left Right Root
        if(root==null) return;

        postOrder(root.left,arr);
        postOrder(root.rgt,arr);
        arr.add(root.data);
    }

    static void inOrder(Node root, ArrayList<Integer> in){
        if(root==null) return;

        inOrder(root.left,in);        // T.C = O(n)
        in.add(root.data);    // S.C = best = O(logn) and worst = O(n)
        inOrder(root.rgt,in);

    }

    static Node preOrderAndInorderToBinaryTree(int pre[], int preLow, int preHigh, int in[], int inLow, int inHigh){

        if(preLow>preHigh || inLow>inHigh) return null;

        Node root = new Node(pre[preLow]);

        int idx=-1;
        int target=root.data;
        for(int i=inLow; i<=inHigh; i++){
            if(in[i]==target){
                idx=i;
                break;
            }
        }

        int len = idx-inLow;

        root.left=preOrderAndInorderToBinaryTree(pre,preLow+1,preLow+len,in,inLow,idx-1);
        root.rgt=preOrderAndInorderToBinaryTree(pre,preLow+len+1,preHigh,in,idx+1,inHigh);

        return root;
    }

    static Node postOrderAndInorderToBinaryTree(int post[], int postLow, int postHigh, int in[], int inLow, int inHigh) {
       if(postLow>postHigh || inLow>inHigh) return null;

       Node root = new Node(post[postHigh]);

       int idx = -1;
       int target=root.data;

       for(int i=inLow; i<=inHigh; i++){
           if(in[i]==target){
               idx=i;
               break;
           }
       }
       int len = inHigh-idx;

       root.left=postOrderAndInorderToBinaryTree(post,postLow,postHigh-len-1,in,inLow,idx-1);
       root.rgt=postOrderAndInorderToBinaryTree(post,postHigh-len,postHigh-1,in,idx+1,inHigh);

       return root;
    }

    static void flattenABinaryTreeToALinkedList(Node root){
        if(root==null) return;

        flattenABinaryTreeToALinkedList(root.left);   // T.C = O(n)
        flattenABinaryTreeToALinkedList(root.rgt);    // S.C = O(height)

        Node t = root.rgt;
        root.rgt=root.left;
        Node temp = root;
        while(temp.rgt!=null){
            temp=temp.rgt;
        }
        temp.rgt=t;
    }

    static void flattenABinaryTreeToALinkedList2(Node root){
        if(root==null || (root.left==null && root.rgt==null)) return;

        Node curr = root;     // S.C = O(1);
        while(curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;
                while(pred.rgt!=null){
                    pred=pred.rgt;
                }
                pred.rgt=curr.rgt;
                curr.rgt=curr.left;
                curr.left=null;
            }
            curr=curr.rgt;
        }
    }


    static int timeToburnABinaryTree(Node root, int start){
        HashMap<Node, Node> hp = new HashMap<>();

        HashMap<Node, Integer> ans = new HashMap<>();

        childParent(root,hp);
        Node head = findANode(root,start);

        findingLevelOfAGraphUsingBFS(head,ans,hp);

        int count=0;
        for(var x : ans.values()){
            count = Math.max(x,count);
        }

        return count;
    }

    static void childParent(Node root, HashMap<Node, Node> hp){
        if(root==null) return;

        if(root.left!=null) hp.put(root.left,root);
        if(root.rgt!=null) hp.put(root.rgt,root);

        childParent(root.left,hp);
        childParent(root.rgt,hp);
    }

    static Node findANode(Node root, int target){
        if(root==null) return null;
        if(root.data==target) return root;

        Node a = findANode(root.left,target);
        Node b = findANode(root.rgt,target);

        if(a==null) return b;
        else return a;
    }

    static void findingLevelOfAGraphUsingBFS(Node root, HashMap<Node,Integer> visited, HashMap<Node,Node> hp){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        visited.put(root,0);

        while(q.size()!=0){
            Node t = q.remove();
            int level = visited.get(t)+1;
            if(t.left!=null && !visited.containsKey(t.left)){
                q.add(t.left);
                visited.put(t.left,level);
            }

            if(t.rgt!=null && !visited.containsKey(t.rgt)){
                q.add(t.rgt);
                visited.put(t.rgt,level);
            }

            if(hp.containsKey(t) && !visited.containsKey(hp.get(t))){
                q.add(hp.get(t));
                visited.put(hp.get(t),level);
            }
        }
    }


    static int sum(Node root, int val){
        if(root==null) return 0;
        int ans = 0;
        if(root.data>=val) ans = ans+root.data;
        return ans+sum(root.rgt,val)+sum(root.left,val);
    }

    static void helper(Node root, ArrayList<Integer> arr, int n){
        if(root==null) return;
        if(n==0){
            arr.add(root.data);
            return;
        }

        helper(root.left,arr,n-1);
        helper(root.rgt,arr,n-1);
    }

    static void rootToLeaf(Node root, HashMap<Integer,Integer> hp, ArrayList<HashMap<Integer,Integer>> ans){
        if(root==null) return;
        if(root.rgt==null && root.left==null){
            if(hp.containsKey(root.data)) hp.put(root.data,hp.get(root.data)+1);
            else hp.put(root.data,1);

            HashMap<Integer,Integer> h = new HashMap<>();

            for(var a : hp.keySet()){
                h.put(a,hp.get(a));
            }

            ans.add(h);

            hp.remove(root.data);  // BackTracking
            return;
        }

        if(hp.containsKey(root.data)) hp.put(root.data,hp.get(root.data)+1);
        else hp.put(root.data,1);
        rootToLeaf(root.left,hp,ans);
        rootToLeaf(root.rgt,hp,ans);
        hp.remove(root.data);  // BackTracking

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
                t.rgt=a;
                q.add(a);
            }
        }
        return root;
    }




        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.rgt = b;

        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.rgt = d;

        Node e = new Node(6);
        Node g = new Node(7);
        b.rgt = e;
        b.left = g;

        Node f = new Node(8);
        Node h = new Node(9);
        e.left = f;
        e.rgt = h;

      //  printingLevelWise(root);



    }
}


