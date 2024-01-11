package BackTracking2;

import java.util.*;
import java.util.Arrays;

public class Practice {
    static HashSet<Integer> hp;
    static long dp[][];

    static long helper(int x, int sum, ArrayList<Integer> arr) {
        if (sum == 0) {
            hp.add(arr.size());
            return hp.size();
        }
        if (sum < 0) return 0;
        if (x > sum) return 0;

        if (dp[x][sum] != -1) return dp[x][sum];

        arr.add(x);
        long a = helper(x + 2, sum - x, arr);
        arr.remove(arr.size() - 1);
        long b = helper(x + 2, sum, arr);
        return dp[x][sum] = a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


    }
}