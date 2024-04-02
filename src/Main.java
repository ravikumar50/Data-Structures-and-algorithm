import java.util.*;



public class Main {

    static int ans[];
    static void helper(int arr[], int l, int r, int idx){
        if(l==r){
            ans[idx] = arr[l];
            return;
        }

        int mid = (l+r)/2;
        helper(arr,l,mid,2*idx+1);
        helper(arr,mid+1,r,2*idx+2);
        ans[idx] = Math.max(ans[2*idx+1],ans[2*idx+2]);
    }

    static int query(int l, int r, int low, int high, int idx){
        if(l>=low && r<=high) return ans[idx];
        if(l>high || r<low) return Integer.MIN_VALUE;

        int mid = (l+r)/2;
        int a = query(l,mid,low,high,2*idx+1);
        int b = query(mid+1,r,low,high,2*idx+2);
        return Math.max(a,b);
    }

    public static void main(String[] args) {


        int arr[] = {3,2,1,5,6,1,10,8,6,2};
        int n = arr.length;
        ans = new int[4*n];
        helper(arr,0,n-1,0);
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(query(0,n-1,low,high,0));


    }
}
