package Segment_Trees;

public class Lazy_Propagation {
    static int ans[];
    static int lazy[];
    static int n;

    static void build_tree(int arr[], int low, int high, int idx){
        if(low==high){
            ans[idx] = arr[low];
            return;
        }
        int mid = low+(high-low)/2;
        build_tree(arr,low,mid,2*idx+1);
        build_tree(arr,mid+1,high,2*idx+2);
        ans[idx] = ans[2*idx+1]+ans[2*idx+2];
    }

    static int range_query(int low, int high, int l, int r, int idx){
        int x = high-low+1;
        // check lazy pending
        if(lazy[idx]!=0){
            ans[idx] = ans[idx] + lazy[idx]*x;
            if(low!=high){
                // send lazy to left and right
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        if(r<low || l>high) return 0;
        if(low>=l && high<=r) return ans[idx];
        int mid = low+(high-low)/2;
        int a = range_query(low,mid,l,r,2*idx+1);
        int b = range_query(mid+1,high,l,r,2*idx+2);
        return a+b+lazy[idx]*x;
    }

    static void change_update(int low, int high, int l, int r, int val, int idx){
        int x = high-low+1;
        // check lazy pending
        if(lazy[idx]!=0){
            ans[idx] = ans[idx] + lazy[idx]*x;
            if(low!=high){
                // send lazy to left and right
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        if(r<low || l>high) return;
        if(low>=l && r<=high){

            return;
        }

        int mid = low+(high-low)/2;
        change_update(low,mid,l,r,val,2*idx+1);
        change_update(mid+1,high,l,r,val,2*idx+2);
        ans[idx] = ans[2*idx+1]+ans[2*idx+2];

    }



    public static void main(String[] args) {
        int arr[] = {1,4,2,8,6,4,9,3};
        n = arr.length;
        ans = new int[4*n];
        lazy = new int[4*n];
        build_tree(arr,0,n-1,0);
        System.out.println(range_query(0,n-1,1,3,0));
       // change_update(0,n-1,2,5,2,0);
        System.out.println(range_query(0,n-1,1,3,0));
    }
}
