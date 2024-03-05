package Segment_Trees;

import java.util.Scanner;

public class Range_sum_Query_Mutable {

    // leetcode 307

    static int ans[];
    static int n;

    static void build_sum_tree(int arr[], int low, int high, int idx){
        if(low>high) return;
        if(low==high){
            ans[idx] = arr[low];
            return;
        }

        int mid = low+(high-low)/2;

        build_sum_tree(arr,low,mid,2*idx+1);
        build_sum_tree(arr,mid+1,high,2*idx+2);
        ans[idx] = ans[2*idx+1]+ans[2*idx+2];
    }

    static int range_sum_query(int low, int high, int idx, int l, int r){
        if(low>=l && high<=r) return ans[idx];
        if(r<low || l>high) return 0;

        int mid = low + (high-low)/2;
        int a = range_sum_query(low,mid,2*idx+1,l,r);
        int b = range_sum_query(mid+1,high,2*idx+2,l,r);
        return a+b;
    }

    static void update_change(int low, int high, int i, int val,int idx){
        if(low==high){
            ans[idx] = val;
            return;
        }
        int mid = low+(high-low)/2;
        if(i<=mid) update_change(low,mid,i,val,2*idx+1);
        else update_change(mid+1,high,i,val,2*idx+2);
        ans[idx] = ans[2*idx+1]+ans[2*idx+2];
    }

    static void update(int idx, int val){
        update_change(0,n-1,idx,val,0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {-1};
        n = arr.length;
        int x = (int)Math.pow(2,(int)Math.ceil(Math.log(2*n)/Math.log(2)))-1;
        ans = new int[x];  // contains the sum of elements at the root
        build_sum_tree(arr,0,n-1,0);
        System.out.println(range_sum_query(0,n-1,0,0,0));
        update(0,1);
        System.out.println(range_sum_query(0,n-1,0,0,0));

    }


}
