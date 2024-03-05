package Segment_Trees;
import java.util.*;
public class Frequency_range_query {

    // leetcode 2080

    static HashMap<Integer,Integer> ans[];
    static int n;

    static int arr[];
    static void build_Tree(int l, int r, int idx){
        if(l==r){
            ans[idx].put(arr[l],1);
            return;
        }

        int mid = l+(r-l)/2;
        build_Tree(l,mid,2*idx+1);
        build_Tree(mid+1,r,2*idx+2);
        ans[idx] = add_Maps(ans[2*idx+1],ans[2*idx+2]);
    }

    static HashMap<Integer,Integer> add_Maps(HashMap<Integer,Integer>hp1, HashMap<Integer,Integer> hp2){
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(var a : hp1.keySet()){
            hp.put(a,hp1.get(a)+hp2.getOrDefault(a,0));
        }

        for(var a : hp2.keySet()){
            hp.put(a,hp2.get(a)+hp1.getOrDefault(a,0));
        }
        return hp;
    }


    static int freq_query(int low, int high, int l, int r, int idx, int val){
        if(r<low || l>high) return 0;
        if(low>=l && high<=r) return ans[idx].getOrDefault(val,0);

        int mid = low+(high-low)/2;
        int a = freq_query(low,mid,l,r,2*idx+1,val);
        int b = freq_query(mid+1,high,l,r,2*idx+2,val);
        return a+b;

    }

    public static void main(String[] args) {
        int nums[] = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        n = nums.length;
        arr = nums;
        int x = (int)Math.pow(2,(int)Math.ceil(Math.log(2*n)/Math.log(2)))-1;
        ans = new HashMap[x];
        for(int i=0; i<x; i++) ans[i] = new HashMap<>();
        build_Tree(0,n-1,0);
        int left = 0;
        int right = 10;
        int value = 33;
        System.out.println(freq_query(0,n-1,left,right,0,value));
    }

}
