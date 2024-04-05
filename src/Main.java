

public class Main {
    static int ans[];
    static int lazy[];
    static int n;


    static void build_tree(int arr[], int low, int high, int idx){

        if(low==high){
            ans[idx] = arr[low];
            return;
        }

        int mid = (low+high)/2;
        build_tree(arr,low,mid,2*idx+1);
        build_tree(arr,mid+1,high,2*idx+2);
        ans[idx] = ans[2*idx+1]+ans[2*idx+2];
    }

    static int range_query(int low, int high, int l, int r, int idx){

        // pending lazy
        if(lazy[idx]!=0){
            int len = high-low+1;
            ans[idx] = ans[idx]+(len*lazy[idx]);
            if(low!=high){
                // send lazy to left and right child
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx] = 0;
        }

        if(l>high || r<low) return 0;
        if(l<=low && r>=high) return ans[idx];


        int mid = (low+high)/2;
        int a = range_query(low,mid,l,r,2*idx+1);
        int b = range_query(mid+1,high,l,r,2*idx+2);
        return a+b;
    }

    static void change_update(int low, int high, int l, int r, int val, int idx){
        // pending lazy
        if(lazy[idx]!=0){
            int len = high-low+1;
            ans[idx] = ans[idx]+(len*lazy[idx]);
            if(low!=high){
                // send lazy to left and right child
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx] = 0;
        }

        if(l>high || r<low) return;
        if(l<=low && r>=high){
            int len = high-low+1;
            ans[idx] = ans[idx]+(val*len);
            if(low!=high){
                lazy[2*idx+1]+=val;
                lazy[2*idx+2]+=val;
            }
            return;
        }

        int mid = (low+high)/2;
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
        System.out.println(range_query(0,n-1,2,6,0));
        change_update(0,n-1,2,5,10,0);
        System.out.println(range_query(0,n-1,2,6,0));
    }
}
