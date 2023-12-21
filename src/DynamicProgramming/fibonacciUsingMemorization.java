package DynamicProgramming;

public class fibonacciUsingMemorization {

    static int calls = 0;
    static int helper(int n, int[] dp){

        if(dp[n]!=-1) return dp[n];
        else{
            calls++;
            return dp[n] = helper(n-1,dp)+helper(n-2,dp);
        }
    }
    public static void main(String[] args) {
        int n = 15;
        int dp[] = new int[n+1];
        for(int i=2; i<n+1; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;

        System.out.println(helper(n,dp));
        System.out.println(calls);
    }
}
