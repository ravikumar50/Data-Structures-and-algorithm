package Stacks;

import java.util.*;

public class CelebrityProblem {

    static int celebrity(int arr[][]){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }

        while(st.size()>1){
            int v1 = st.pop();
            int v2 = st.pop();

            if(arr[v1][v2]==1) st.push(v2);
            else if(arr[v2][v1]==1) st.push(v1);
        }
        if(st.size()==0) return -1;
        if(st.size()==1){
            for(int i=0; i<n; i++) {
                if (arr[st.peek()][i] == 1) return -1;
            }
        }
        return st.peek();
    }

    static int[] maximumSlidingWindow(int arr[], int k){
        int n = arr.length;        // TC = O(n*k);
        int ans[] = new int[n-k+1];

        for(int i=0; i<n-k+1; i++){
            int a=arr[i];
            for(int j=0; j<k; j++){
                if(arr[i+j]>=a){
                    a = arr[i+j];
                }
            }
            ans[i]=a;
        }

        return ans;
    }

    static int[] nextGreater(int arr[]){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        ans[n-1]=n;
        st.push(n-1);


        for(int i=n-2; i>=0; i--){
            while(st.size()!=0 && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.size()==0) ans[i]=n;
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }

    static int[] maximumSlidingWindow2(int arr[], int k){;
        int n = arr.length;
        int ans[] = new int[n-k+1];


        int nge[] = nextGreater(arr);
        int j = 0;
        for(int i=0; i<n-k+1; i++){
            int max=arr[i];
            if(j>=i+k) j=i;
            while(j<i+k){
                max=arr[j];
                j=nge[j];
            }
            ans[i]=max;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
