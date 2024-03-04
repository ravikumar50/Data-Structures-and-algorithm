package Segment_Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class Building_Segment_Tree {

    static int ans[];
    static void building_tree_max(int arr[], int l, int r, int idx){
        if(l>r) return;
        if(l==r){
            ans[idx] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        building_tree_max(arr,l,mid,2*idx+1);  // left subtree
        building_tree_max(arr,mid+1,r,2*idx+2);   // right subtree
        int a = ans[2*idx+1];
        int b = ans[2*idx+2];
        ans[idx] = Math.max(a,b);   // max of left and right subtrer
    }

    static int queury_answer_max(int low, int high, int idx, int l, int r){
        if(low>=l && high<=r) return ans[idx];  // inside range
        if(high<l || low>r) return Integer.MIN_VALUE;  // out of range


        // overlapping
        int mid = (low+high)/2;
        int a = queury_answer_max(low,mid,2*idx+1,l,r);
        int b = queury_answer_max(mid+1,high,2*idx+2,l,r);
        return Math.max(a,b);
    }

    static void building_tree_min(int arr[], int l, int r, int idx){
        if(l>r) return;
        if(l==r){
            ans[idx] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        building_tree_min(arr,l,mid,2*idx+1);
        building_tree_min(arr,mid+1,r,2*idx+2);
        int a = ans[2*idx+1];
        int b = ans[2*idx+2];
        ans[idx] = Math.min(a,b);

    }

    static int queury_answer_min(int low, int high, int idx, int l, int r){
        if(low>=l && high<=r) return ans[idx];  // inside range
        if(high<l || low>r) return Integer.MAX_VALUE;  // out of range
        else{

            // overlapping
            int mid = (low+high)/2;
            int a = queury_answer_min(low,mid,2*idx+1,l,r);
            int b = queury_answer_min(mid+1,high,2*idx+2,l,r);
            return Math.min(a,b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,4,2,8,6,4,9,3};
        int n = arr.length;
        int x = (int)Math.pow(2,(int)Math.ceil(Math.log(2*n)/Math.log(2)))-1;
        ans = new int[x];      // actual size will be x but you should use 4*n for safer side
        building_tree_min(arr,0,n-1,0);


        int q = sc.nextInt();  // number of queries
        for(int i=0; i<q; i++){
            int l = sc.nextInt();  // left range
            int r = sc.nextInt();  // right range
            System.out.println("Maximum/Minimum element betwenn index "+l+" to "+r+" is "+queury_answer_min(0,n-1,0,l,r));
        }
    }
}

/*
5
1 5
3 7
2 5
0 6
3 6
 */

