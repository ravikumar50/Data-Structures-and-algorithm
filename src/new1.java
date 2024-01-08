import java.util.*;

public class new1 {


    static int dp[];

    static int helper(int arr[], int idx, int sum){
        if(idx>=arr.length){
            if(sum!=0 && (sum%20==0 || sum%24==0)) return 1;
            else return 0;
        }

       // if(dp[idx]!=-1) return dp[idx];

        int a = helper(arr,idx+1,sum+arr[idx]);
        int b = helper(arr,idx+1,sum);

        if(a==0 && b==0) return dp[idx] = 0;
        else return dp[idx] = 1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 8, 9 ,10, 14, 2 ,3 ,5};
        dp = new int[380];
        Arrays.fill(dp,-1);
        int ans = helper(arr,0,0);
        System.out.println(ans);
    }
}
