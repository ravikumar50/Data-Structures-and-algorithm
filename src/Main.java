import java.util.*;
public class Main {


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
        for(int i=l; i<=r; i++){
            int a = arr[i];
            int f1 = ans[2*idx+1].getOrDefault(a,0);
            int f2 = ans[2*idx+2].getOrDefault(a,0);
            ans[idx].put(a,f1+f2);
        }
    }

    static HashMap<Integer,Integer> freq_query(int low, int high, int l, int r, int idx){
        if(r<low || l>high) return new HashMap<>();
        if(low>=l && high<=r) return ans[idx];

        int mid = low+(high-low)/2;
        HashMap<Integer,Integer> hp1 = freq_query(low,mid,l,r,2*idx+1);
        HashMap<Integer,Integer> hp2 = freq_query(mid+1,high,l,r,2*idx+2);
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i=low; i<=high; i++){
            int a = arr[i];
            int f1 = hp1.getOrDefault(a,0);
            int f2 = hp2.getOrDefault(a,0);
            hp.put(a,f1+f2);
        }
        return hp;
    }
    static int query(int left, int right, int value) {
        HashMap<Integer,Integer> hp = freq_query(0,n-1,left,right,0);
        return hp.get(value);
    }

    public static void main(String[] args) {
        int nums[] = {12,33,4,56,22,2,34,33,22,12,34,56};
        int n = nums.length;
        arr = nums;
        int x = (int)Math.pow(2,(int)Math.ceil(Math.log(2*n)/Math.log(2)))-1;
        ans = new HashMap[x];
        for(int i=0; i<x; i++) ans[i] = new HashMap<>();
        build_Tree(0,n-1,0);
        System.out.println(ans[0]);
        ;
        System.out.println(query(0,2,4));
    }
}
