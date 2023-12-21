package Queue;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question {

    static Queue reverseAQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(q.size()>0){
            st.push(q.remove());
        }

        while(st.size()>0){
            q.add(st.pop());
        }

        return q;
    }

    static Queue reverseFirstKElements(Queue<Integer> q,int k){
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<k; i++){
            st.push(q.remove());
        }

        while(st.size()>0){
            q.add(st.pop());
        }
        for(int i=0; i<q.size()-k; i++){
            q.add(q.remove());
        }
        return q;
    }

    static int[] firstNegativeIntegerInWindowOfSizeK(int arr[], int k){
        int n = arr.length;
        int ans[] = new int[n-k+1];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(arr[i]<0) q.add(i);
        }

        for(int i=0; i<n-k+1; i++){
            if(q.size()>0 && q.peek()<i) q.remove();

            if(q.size()==0 || q.peek()>i+k-1) ans[i]=0;
            else if(q.peek()>=i && q.peek()<=i+k-1) {
                ans[i] = arr[q.peek()];
            }
        }
        return ans;
    }

    static Queue interLeaveQueueUisngQueue(Queue<Integer> q){
        int n = q.size();

        Queue<Integer> val = new LinkedList<>();
        int x = n/2;

        for(int i=1; i<=x; i++){
            val.add(q.remove());
        }

        for(int i=1; i<=x; i++){
            q.add(val.remove());
            q.add(q.remove());
        }
        return q;
    }

    static Queue interLeaveQueueUsingStack(Queue<Integer> q){
        int n = q.size();
        int x = n/2;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<x; i++){
            st.push(q.remove());
        }

        for(int i=0; i<x; i++){
            q.add(st.pop());
        }

        for(int i=0; i<x; i++){
            st.push(q.remove());
        }

        for(int i=0; i<x; i++){
            q.add(st.pop());
            q.add(q.remove());
        }

        for(int i=0; i<n; i++){
            st.push(q.remove());
        }

        for(int i=0; i<n; i++){
            q.add(st.pop());
        }

        return q;

    }


    public static void main(String[] args) {
        Queue q = new LinkedList();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        int arr[] = {12,-1,-7,8,-15,30,16,28};

        int ans[]=firstNegativeIntegerInWindowOfSizeK(arr,3);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
