package Stacks;

import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class Questions{

    static Stack copyStack(Stack<Integer> s1){
        int n = s1.size();
        if(n==0) return s1;

        int a = s1.peek();
        s1.pop();
        Stack s = copyStack(s1);
        s.push(a);
        return s;
    }

    static Stack copyStack2(Stack s1){
        int n = s1.size();

        Stack s = new Stack();
        for(int i=0; i<n; i++){
            s.push(s1.pop());
        }
        Stack ans = new Stack();

        for(int i=0; i<n; i++){
            ans.push(s.pop());
        }
        return ans;
    }

    static Stack insertAt(Stack<Integer> st, int x, int idx){
        int n = st.size();
        if(idx<0 || idx>n){
            System.out.println("Wrong Index");
            return st;
        }
        Stack<Integer> s = new Stack();

        while(st.size()>idx){
            s.push(st.pop());
        }

        st.push((x));

        while(s.size()>0){
            st.push(s.pop());
        }

        return st;
    }

    static void insertAt2(Stack<Integer> st, int x, int idx){
        if(idx==st.size()){
            st.push(x);
            return;
        }
        int a = st.pop();
        insertAt(st,x,idx);
        st.push(a);
        return;
    }

    static Stack deleteAt(Stack st, int idx){

        if(idx<0 || idx >st.size()-1){
            System.out.println("Wrong Index");
            return st;
        }
        Stack temp = new Stack();
        while(st.size()>idx){
            temp.push(st.pop());
        }
        temp.pop();

        while(temp.size()>0){
            st.push(temp.pop());
        }
        return st;
    }

    static void deleteAt2(Stack<Integer> st, int x, int idx){
        if(idx==st.size()-1){
            st.pop();
            return;
        }
        int a = st.pop();
        deleteAt2(st,x,idx);
        st.push(a);
        return;
    }

    static void printUsingExtraStack(Stack st){

        Stack temp = new Stack();
        while(st.size()>0){
            temp.push(st.pop());
        }
        while(temp.size()>0){
            System.out.print(temp.peek()+" ");
            st.push(temp.pop());
        }
        System.out.println();
        return;
    }

    static void printUsingArray(Stack<Integer> st){
        int n = st.size();

        int[] arr = new int[n];

        for(int i=n-1; i>=0; i--){
            arr[i]=st.pop();
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
            st.push(arr[i]);
        }
        System.out.println();
        return;
    }

    static void printUsingRecursion(Stack<Integer> st){
        int n = st.size();
        if(n==0) return;
        int a = st.pop();
        printUsingRecursion(st);
        System.out.print(a+" ");
        st.push(a);

        return;
    }

    static void insertAtBottomUsingRecursion(Stack<Integer> st, int x){
        if(st.size()==0){
            st.push(x);
            return;
        }
        int a = st.pop();
        insertAtBottomUsingRecursion(st,x);
        st.push(a);
        return;
    }

    static void reverseAStackRecursion(Stack<Integer> st){

        if(st.size()==1) return;
        int a = st.pop();

        reverseAStackRecursion(st);
        insertAtBottomUsingRecursion(st,a);
        return;
    }

    static void reverseAStack(Stack<Integer> st){

        Stack<Integer> a = new Stack();
        Stack<Integer> b = new Stack();

        while(st.size()>0){
            a.push(st.pop());
        }

        while(a.size()>0){
            b.push(a.pop());
        }

        while(b.size()>0){
            st.push(b.pop());
        }
        return;
    }

    static void deleteBottom(Stack<Integer> st){
        if(st.size()==1){
            st.pop();
            return;
        }
        int a = st.pop();
        deleteBottom(st);
        st.push(a);
        return;
    }

    static boolean balancedBracket(String s){

       Stack<Character> st = new Stack<>();

       for(int i=0; i<s.length(); i++){
           if(s.charAt(i)=='('){
               st.push(s.charAt(i));
           }else{
               if(st.size()==0) return false;
               else{
                   st.pop();
               }
           }
       }

       if(st.isEmpty()) return true;
       else return false;
    }

    static int minimumBracketToMakeBalanced(String s){
        int n = s.length();

        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{
                if(st.size()==0) ans++;
                else st.pop();
            }
        }
        ans = ans+st.size();

        return ans;
    }

    static boolean balancedBrackets2(String s){

        int n = s.length();

        Stack<Character> st = new Stack<>();
        Stack<Character> val = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='(') st.push(ch);
            else if(ch=='*') val.push(ch);
            else{
                if(st.size()==0){
                    if(val.size()!=0){
                        val.pop();
                    }else{
                        return false;
                    }
                }else{
                    st.pop();
                }
            }
        }
        if(st.size()==0 || st.size()<=val.size()) return true;
        else return false;

    }

    static int[] removeConsecutiveSeqeunce(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();



        for(int i=0; i<n; i++){
            if(st.size()==0 || st.peek()!=arr[i]){
                st.push(arr[i]);
            }else if(st.peek()==arr[i]){
                 if(i==n-1 || arr[i]!=arr[i+1]){
                     st.pop();
                 }
            }
        }

        int ans[] = new int[st.size()];

        for(int i=ans.length-1; i>=0; i--){
            ans[i]=st.pop();
        }
        return ans;
    }

    static int[] nextGreater(int arr[]){
        int n = arr.length;

        int ans[] = new int[n];


        for(int i=0; i<n; i++){
            ans[i]=-1;
            for(int j=i; j<n; j++){
                if(arr[i]<arr[j]){
                    ans[i]=arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    static int[] nextGreaterUsingStack(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];
        ans[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            if (st.size() == 0) st.push(arr[i]);

            while (st.size() > 0 && st.peek() <= arr[i]) {
                st.pop();
            }

            if(st.size()==0) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    static int[] nextGreaterUsingStackViaIndex(int arr[]){
        int n=arr.length;

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        st.push(0);
        for(int i=1; i<n; i++){
            ans[i]=-1;
            while(st.size()!=0 && arr[i]>=arr[st.peek()]) {
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }

    static int[] stockSpanOrPreviousGreater(int arr[]){
        int n = arr.length;

        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        ans[0]=1;
        st.push(0);

        for(int i=1; i<n; i++){
            while(st.size()!=0 && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.size()==0) ans[i]=i+1;
            else ans[i]=i-st.peek();

            st.push(i);
        }

        return ans;

    }

    static int[] nextSmaller(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];
        st.push(arr[n-1]);
        ans[n-1]=-1;
        for(int i=n-2; i>=0; i--){

            while(st.size()!=0 && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.size()==0) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    static int[] previousSmaller(int arr[]){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        ans[0]=-1;
        st.push(arr[0]);

        for(int i=1; i<n; i++){
            while(st.size()!=0 && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.size()==0) ans[i]=-1;
            else ans[i]=st.peek();

            st.push(arr[i]);
        }
        return ans;
    }

    static int[] nextSmallerindex(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];
        st.push(n-1);
        ans[n-1]=n;
        for(int i=n-2; i>=0; i--){

            while(st.size()!=0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0) ans[i]=n;
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }

    static int[] previousSmallerIndex(int arr[]){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        ans[0]=-1;
        st.push(0);

        for(int i=1; i<n; i++){
            while(st.size()!=0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0) ans[i]=-1;
            else ans[i]=st.peek();

            st.push(i);
        }
        return ans;
    }

    static int maximumAreaRectangle(int arr[]){    //leetcode - 84

        int nse[] = nextSmallerindex(arr);
        int pse[] = previousSmallerIndex(arr);

        int n = arr.length;
        int area = -1;

        for(int i=0; i<n; i++){
            int height=arr[i];
            int breadth=Math.abs((nse[i]-pse[i]))-1;
            int a = height*breadth;

            if(a>area) area = a;
        }
        return area;
    }

    static int getMin(Stack<Integer> st){   // Time Complexity is order of(n);
        int min = Integer.MAX_VALUE;        // leetcode - 155

        Stack<Integer> gt = new Stack();

        while(st.size()>0){
            if(st.peek()<=min) min = st.peek();

            gt.push(st.pop());
        }
        return min;
    }

    static String reverseEachLetterInAString(String s){
        int n = s.length();

        Stack<String> st = new Stack<>();

        String ans = "";


        for(int i=n-1; i>=0; i--){


            if(s.charAt(i)!='.'){
                while(s.charAt(i)!='.'){
                    if(st.size()==0) st.push(""+s.charAt(i));
                    else st.push(st.pop()+s.charAt(i));
                    i--;
                    if(i==-1){
                        ans=st.pop()+ans;
                        break;
                    }
                }
                i++;
            }else{
                if(st.size()>0){
                    st.push(s.charAt(i)+st.pop());
                }else{
                    st.push(""+s.charAt(i));
                }
                ans=st.pop()+ans;

            }
        }
        return ans;
    }

    static int stringManipulation(String arr[]){
        int n = arr.length;
        Stack<String> st = new Stack<>();

        for(int i=0; i<n; i++){
            String a = arr[i];

            if(st.size()==0) st.push(a);
            else {
                String b = st.peek();
                if(a==b) st.pop();
                else st.push(a);
            }
        }

        return st.size();

    }

    static String reverseAEquation(String s){
        int n = s.length();

        Stack<String> st = new Stack<>();
        String ans="";

        for(int i=n-1; i>=0; i--){

            char ch = s.charAt(i);
            int a = ch-48;
            if(a>=0 && a<=9){

                while(s.charAt(i)!='+' && s.charAt(i)!='-' && s.charAt(i)!='*' && s.charAt(i)!='/'){
                    if(st.size()==0) st.push(""+s.charAt(i));
                    else st.push(s.charAt(i)+st.pop());
                    i--;
                    if(i==-1){
                        ans=ans+st.pop();
                        break;
                    }
                }
                i++;
            }else{
                if(st.size()>0){
                    st.push(st.pop()+ch);
                }else{
                    st.push(""+ch);
                }
                ans=ans+st.pop();

            }
        }


        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";

        System.out.println(balancedBrackets2(s));


    }
}
