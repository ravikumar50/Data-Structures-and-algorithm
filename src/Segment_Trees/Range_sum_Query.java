package Segment_Trees;

import java.util.Scanner;

public class Range_sum_Query {

    static int ans[];

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,2,3,4,5,6};
        int n = arr.length;
        int x = (int)Math.pow(2,(int)Math.ceil(Math.log(2*n)/Math.log(2)))-1;
        ans = new int[x];  // contains the sum of elements at the root
        build_sum_tree(arr,0,n-1,0);
        for(var a : ans) System.out.print(a+" ");
        int q = sc.nextInt();
        while(q-->0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println("Sum in the range of index " + l + " to " + r + " is " + range_sum_query(0, n - 1, 0, l, r));
        }
    }


}
