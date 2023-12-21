package DynamicProgramming;

import java.util.Arrays;

public class Fibbo {

    static int dp[];

    static int fibboTopDown(int n){       // T.C = O(n)
        if(n==0 || n==1) return n;        // S.C = O(n)(stack)+O(n)(dp array) = O(n)

        if(dp[n]!=-1) return dp[n];
        else return dp[n] = fibboTopDown(n-1)+fibboTopDown(n-2);
    }

    static int fibboBottomUp(int n){    // T.C = O(n)
                                        // S.C = O(n)
        if(n==0 || n==1) return n;

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    static int fiboo(int n){   // T.C = O(n)
                               // S.C = O(1)

        if(n==0 || n==1) return n;

        int a = 0;
        int b = 1;
        int c = a+b;

        for(int i=2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        int n = 10;



    }
}
