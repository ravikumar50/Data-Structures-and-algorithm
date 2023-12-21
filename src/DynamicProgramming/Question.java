package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.*;

public class Question {

    static int houseRobber(int arr[], int idx, int dp[]) {  //leetcode 198
        if (idx < 0) return 0;


        if (idx == 0) {
            return dp[idx] = arr[idx];
        } else if (idx == 1) {
            return dp[idx] = Math.max(arr[idx], arr[idx - 1]);
        }

        if (dp[idx] != -1) return dp[idx];
        else {
            int a = arr[idx] + houseRobber(arr, idx - 2, dp);
            int b = houseRobber(arr, idx - 1, dp);
            return dp[idx] = Math.max(a, b);
        }
    }

    static int decodeWays(String s, int idx, int dp[]) {    // leetcode 91
        if (idx >= s.length()) return 1;

        if (idx == s.length() - 1) {
            if (s.charAt(idx) > 0) return 1;
            else return 0;
        }

        if (dp[idx] != -1) return dp[idx];
        else {
            int notCombine = 0;
            int combine = 0;

            if (s.charAt(idx) > '0') notCombine = decodeWays(s, idx + 1, dp);

            int x = s.charAt(idx) - 48;
            int y = s.charAt(idx + 1) - 48;

            if (x == 1 || (x == 2 && y <= 6)) {
                combine = decodeWays(s, idx + 2, dp);
            }

            System.out.println(notCombine);
            System.out.println(combine);

            return dp[idx] = combine + notCombine;
        }
    }

    static int coinChangeRuccursive(int arr[], int sum, int idx) {  // Leetcode - 518

        if (sum < 0 || idx >= arr.length) return 0;
        if (sum == 0) return 1;

        int pick = coinChangeRuccursive(arr, sum - arr[idx], idx);
        int notPick = coinChangeRuccursive(arr, sum, idx + 1);
        return pick + notPick;
    }

    static int coinChangeDP(int arr[], int sum, int idx, int dp[][]) {  // tabulation


        if (sum < 0 || idx >= arr.length) return 0;
        if (sum == 0) {
            return dp[idx][sum] = 1;
        }

        if (dp[idx][sum] != -1) return dp[idx][sum];
        else {
            int pick = coinChangeDP(arr, sum - arr[idx], idx, dp);
            int notPick = coinChangeDP(arr, sum, idx + 1, dp);
            return dp[idx][sum] = pick + notPick;
        }

    }


    static int minimumCostFrog2(int arr[], int st, int k, int dp[]) {  // Atcoder - Frog 2

        // topDown appraoch

        // T.C = O(n*k)
        // S.C = O(n+n) = O(n)

        if (st == arr.length - 1) return 0;


        if (dp[st] != -1) return dp[st];
        else {
            int ans = Integer.MAX_VALUE;

            for (int i = 1; i <= k; i++) {
                if (st + i >= arr.length) break;
                int a = minimumCostFrog2(arr, st + i, k, dp);
                ans = Math.min(ans, a + Math.abs(arr[st] - arr[st + i]));
            }
            return dp[st] = ans;
        }
    }

    static int minimumCostFrog2BottomUp(int arr[], int dp[], int k) {
        // T.C = O(n*k)
        // S.C = O(n)

        int n = arr.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                if (i + j >= arr.length) break;
                dp[i] = Math.min(dp[i], dp[i + j] + Math.abs(arr[i] - arr[i + j]));
            }
        }

        return dp[0];
    }

    static int partyWithFriendsSingleOrPair(int n, int dp[]) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (dp[n] != -1) return dp[n];
        else return dp[n] = partyWithFriendsSingleOrPair(n - 1, dp) + (n - 1) * partyWithFriendsSingleOrPair(n - 2, dp);
    }


    static int minimimOperationNto1(int n) {  // recursive case
        if (n <= 0) return Integer.MAX_VALUE;
        if (n == 1) return 0;
        if (n == 2 || n == 3) return 1;

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        a = minimimOperationNto1(n - 1);
        if (n % 2 == 0) b = minimimOperationNto1(n / 2);
        if (n % 3 == 0) c = minimimOperationNto1(n / 3);

        return Math.min(a, Math.min(b, c)) + 1;
    }

    static int minimimOperationNto1TopDown(int n, int dp[]) {   // top down
        if (n <= 0) return Integer.MAX_VALUE;
        if (n == 1) return 0;
        if (n == 2 || n == 3) return 1;

        if (dp[n] != -1) return dp[n];

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        a = minimimOperationNto1(n - 1);
        if (n % 2 == 0) b = minimimOperationNto1(n / 2);
        if (n % 3 == 0) c = minimimOperationNto1(n / 3);

        return dp[n] = Math.min(a, Math.min(b, c)) + 1;
    }

    static int minimimOperationNto1BottomUp(int n) {  // bottom up

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        return dp[n];
    }

    static int removingDigitsToMakeItZero(int n) {   // CSES problem set
        // recursive case

        if (n == 0) return 0;
        if (n <= 9) return 1;

        String s = String.valueOf(n);


        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 48;
            if (a != 0) ans = Math.min(ans, removingDigitsToMakeItZero(n - a));
        }
        return ans + 1;

    }

    static int removingDigitsToMakeItZeroTopDown(int n, int dp[]) {   // CSES problem set
        // Top Down

        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        if (n <= 9) return 1;

        String s = String.valueOf(n);


        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 48;

            if (a != 0) {
                if (dp[n - a] != -1) ans = Math.min(ans, dp[n - a]);
                else ans = Math.min(ans, removingDigitsToMakeItZeroTopDown(n - a, dp));
            }
        }
        return dp[n] = ans + 1;

    }

    static int removingDigitsToMakeItZeroBottoDown(int n) {
        int dp[] = new int[1000005];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= 9; i++) dp[i] = 1;


        for (int i = 10; i <= n; i++) {
            String s = String.valueOf(i);
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < s.length(); j++) {
                int a = s.charAt(j) - 48;
                if (a != 0) ans = Math.min(ans, dp[i - a]);
            }
            dp[i] = ans + 1;
        }
        return dp[n];
    }


    static int minimizingCoinTopDown(int sum, int dp[], int arr[]) {   // CSES problem set
        // Top Down

        if (sum == 0) return 0;
        if (dp[sum] != -2) return dp[sum];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (sum - arr[i] < 0) continue;
            ans = Math.min(ans, minimizingCoinTopDown(sum - arr[i], dp, arr));
        }

        if (ans == Integer.MAX_VALUE) return dp[sum] = ans;
        return dp[sum] = ans + 1;

    }

    static int minimizingCoinBottomUp(int sum, int arr[]) {
        int dp[] = new int[1000006];
        Arrays.fill(dp, -2);
        dp[0] = 0;

        for (int i = 1; i <= sum; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] < 0) continue;
                ans = Math.min(ans, dp[i - arr[j]]);
            }
            if (ans == Integer.MAX_VALUE) dp[i] = ans;
            else dp[i] = ans + 1;
        }

        if (dp[sum] == Integer.MAX_VALUE) return -1;
        else return dp[sum];
    }

    static int diceCombinationTopDown(int sum, int dp[]) {     //CSES problem set
        if (sum < 0) return 0;
        if (sum == 0) return 1;

        if (dp[sum] != -1) return dp[sum];

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans = ans + diceCombinationTopDown(sum - i, dp);
        }
        return dp[sum] = ans;
    }

    static int diceCombinationBottomUp(int sum) {     //   CSES Problem Set

        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= sum; i++) {
            int ans = 0;
            for (int j = 1; j <= 6; j++) {
                if (i - j < 0) continue;
                ans = ans + dp[i - j];
            }
            dp[i] = ans;
        }
        return dp[sum];
    }

    static int numberOfDiceRollWithTargetSum(int n, int k, int target, int dp[][]) {  // leetcode 1155
        if (n < 0 || target < 0) return 0;
        if (n == 0 && target == 0) return 1;

        if (dp[n][target] != -1) return dp[n][target];

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (target - i < 0) continue;
            ans = ans + numberOfDiceRollWithTargetSum(n - 1, k, target - i, dp);
        }
        return dp[n][target] = ans;
    }


    static boolean CoinChange(int n, int k, int l) {   // SPOJ

        boolean dp[] = new boolean[1000000];
        dp[1] = true;
        dp[k] = true;
        dp[l] = true;

        for (int i = 2; i <= n; i++) {
            if (i == k || i == l) continue;
            boolean s1 = true;
            boolean s2 = true;
            boolean s3 = true;

            s1 = dp[i - 1];
            if (i - k >= 1) s2 = dp[i - k];
            if (i - l >= 1) s3 = dp[i - l];

            dp[i] = !(s1 && s2 && s3);
        }
        return dp[n];

    }


    static int VacationProblemTopDowm(int n, int idx, int arr[][], int dp[][]) {  // Atcoder
        if (n >= arr.length) return 0;
        if (n == arr.length - 1) return arr[n][idx];

        if (dp[n][idx] != -1) return dp[n][idx];

        if (idx == 0) {
            int a = arr[n][0] + VacationProblemTopDowm(n + 1, 1, arr, dp);
            int b = arr[n][0] + VacationProblemTopDowm(n + 1, 2, arr, dp);

            return dp[n][idx] = Math.max(a, b);
        } else if (idx == 1) {
            int a = arr[n][1] + VacationProblemTopDowm(n + 1, 0, arr, dp);
            int b = arr[n][1] + VacationProblemTopDowm(n + 1, 2, arr, dp);

            return dp[n][idx] = Math.max(a, b);
        } else {
            int a = arr[n][2] + VacationProblemTopDowm(n + 1, 0, arr, dp);
            int b = arr[n][2] + VacationProblemTopDowm(n + 1, 1, arr, dp);

            return dp[n][idx] = Math.max(a, b);
        }
    }


    static int VacationPrioblemBottomUp(int arr[][]) {
        int dp[][] = new int[arr.length][3];

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        int n = arr.length;

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));

    }

    static int longestCommonSubSequenceTopDown(String s1, String s2, int i, int j, int dp[][]) {  // leecode 1143

        if (i >= s1.length() || j >= s2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2) {
            return dp[i][j] = 1 + longestCommonSubSequenceTopDown(s1, s2, i + 1, j + 1, dp);
        } else {
            int a = longestCommonSubSequenceTopDown(s1, s2, i + 1, j, dp);
            int b = longestCommonSubSequenceTopDown(s1, s2, i, j + 1, dp);
            return dp[i][j] = Math.max(a, b);
        }
    }


    static int longestCommonSubsequenceBottomUp(String s1, String s2) {

        // bottom up
        int dp[][] = new int[1005][1005];

        int n1 = s1.length();
        int n2 = s2.length();

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);

                if (ch1 == ch2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    int a = dp[i + 1][j];
                    int b = dp[i][j + 1];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }

        return dp[0][0];

    }

    static String s;

    static String LCSActualString(String s1, String s2, int i, int j, String dp[][]) {  // leecode 1143

        if (i >= s1.length() || j >= s2.length()) {
            return "";
        }

        if (dp[i][j] != "") return dp[i][j];
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2) {
            return dp[i][j] = ch1 + LCSActualString(s1, s2, i + 1, j + 1, dp);
        } else {
            String a = LCSActualString(s1, s2, i + 1, j, dp);
            String b = LCSActualString(s1, s2, i, j + 1, dp);

            return dp[i][j] = (a.length() > b.length()) ? a : b;
        }
    }

    static String LCSActualStringBottomUp(String s1, String s2) {
        int dp[][] = new int[1005][1005];

        int n1 = s1.length();
        int n2 = s2.length();

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);

                if (ch1 == ch2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    int a = dp[i + 1][j];
                    int b = dp[i][j + 1];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }

        String ans = "";

        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                ans = ans + s1.charAt(i);
                i++;
                j++;
            } else if (dp[i + 1][j] > dp[i][j + 1]) i++;
            else j++;
        }
        return ans;

    }

    static int LCSWithKChange(int arr1[], int arr2[], int i, int j, int k, int dp[][][]) {  // Hakkerearth
        if (i >= arr1.length || j >= arr2.length) return 0;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        int x = arr1[i];
        int y = arr2[j];

        int ans = 0;

        if (x == y) {
            ans = 1 + LCSWithKChange(arr1, arr2, i + 1, j + 1, k, dp);
        } else {
            if (k > 0) {
                int c = 1 + LCSWithKChange(arr1, arr2, i + 1, j + 1, k - 1, dp);
                int a = LCSWithKChange(arr1, arr2, i, j + 1, k, dp);
                int b = LCSWithKChange(arr1, arr2, i + 1, j, k, dp);

                ans = Math.max(a, Math.max(b, c));
            } else {
                int a = LCSWithKChange(arr1, arr2, i, j + 1, k, dp);
                int b = LCSWithKChange(arr1, arr2, i + 1, j, k, dp);
                ans = Math.max(a, b);
            }
        }
        return dp[i][j][k] = ans;
    }


    static int bestTimeToBuyAndSellStock4(int arr[], int i, int k, int flag, int dp[][][]) {  // leetcode 188
        if (i == arr.length) return 0;

        if (dp[i][k][flag] != -1) return dp[i][k][flag];

        int ans = Integer.MAX_VALUE;
        ans = bestTimeToBuyAndSellStock4(arr, i + 1, k, flag, dp);   // leave thar stock

        if (flag == 1) {
            ans = Math.max(ans, bestTimeToBuyAndSellStock4(arr, i + 1, k - 1, 0, dp) + arr[i]);  // sell
        } else {
            if (k > 0) ans = Math.max(ans, bestTimeToBuyAndSellStock4(arr, i + 1, k, 1, dp) - arr[i]);  // buy
        }
        return dp[i][k][flag] = ans;
    }

    static int adjacentBitsCount(int n, int k, int turn, int dp[][][]) {   // SPOJ
        if (n == 0) return 1;
        if (n == 1) {
            if (k == 0) return 1;
            else return 0;
        }

        if (dp[n][k][turn] != -1) return dp[n][k][turn];

        if (turn == 1) {
            return dp[n][k][turn] = adjacentBitsCount(n - 1, k, 0, dp) + adjacentBitsCount(n - 1, k - 1, 1, dp);
        } else {
            return adjacentBitsCount(n - 1, k, 0, dp) + adjacentBitsCount(n - 1, k, 1, dp);
        }
    }


    static int minTaps(int arr[]) {   // leetcode 1326

        // Bottom Up
        int n = arr.length - 1;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;


        for (int i = 0; i <= n; i++) {
            int st = Math.max(0, i - arr[i]);
            int end = Math.min(n, i + arr[i]);

            int ans = Integer.MAX_VALUE;

            for (int j = st; j <= end; j++) {
                ans = Math.min(ans, dp[j]);
            }

            if (ans != Integer.MAX_VALUE) dp[end] = Math.min(ans + 1, dp[end]);
        }

        if (dp[n] == Integer.MAX_VALUE) return -1;
        else return dp[n];
    }


    static String smallestCommonSequence(String s1, String s2) {    // leetcode 1092

        String s = LCSActualStringBottomUp(s1, s2);

        String ans = "";


        int i = 0, j = 0;

        for (int k = 0; k < s.length(); k++) {

            char c = s.charAt(k);

            while (s1.charAt(i) != c) ans += s1.charAt(i++);
            while (s2.charAt(j) != c) ans += s2.charAt(j++);

            ans += c;
            i++;
            j++;
        }

        return ans + s1.substring(i) + s2.substring(j);
    }

    static int Pilots(int arr[][], int i, int diff, int dp[][]) {  // diff = assist-cap
        // from main function pass i=1 and diff=1 and ans would be Pilots(1,1)+arr[0][1]--assistant

        if (dp[i][diff] != -1) return dp[i][diff];
        if (i == arr.length) return 0;

        if (diff == 0) {
            return dp[i][diff] = arr[i][1] + Pilots(arr, i + 1, diff + 1, dp);
        } else if (diff == arr.length - i) {
            return dp[i][diff] = arr[i][0] + Pilots(arr, i + 1, diff - 1, dp);
        } else {    //assist>cap
            int a = arr[i][1] + Pilots(arr, i + 1, diff + 1, dp);
            int b = arr[i][0] + Pilots(arr, i + 1, diff - 1, dp);

            return dp[i][diff] = Math.min(a, b);
        }
    }


    static int knapsack01(int arr[][], int i, int w, int dp[][]) {   // atcoder
        if (i == arr.length) return 0;

        if (dp[i][w] != -1) return dp[i][w];

        int a = 0, b = 0;
        if (w >= arr[i][0]) a = arr[i][1] + knapsack01(arr, i + 1, w - arr[i][0], dp);
        b = knapsack01(arr, i + 1, w, dp);

        return dp[i][w] = Math.max(a, b);
    }

    static int Knapsack01BottomUp(int wt[], int val[], int W) {
        int n = wt.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int w = 0; w <= W; w++) {
                int a = 0, b = 0;
                if (w >= wt[i]) a = val[i] + dp[i + 1][w - wt[i]];
                b = dp[i + 1][w];
                dp[i][w] = Math.max(a, b);
            }
        }
        return dp[0][W];
    }


    static long Knapsack01Variation(int wt[], int val[], int i, int v, long dp[][]) {    // same as previous one but with change in the contrains of the values . See on Atcoder
        if (v == 0) return 0;
        if (i == wt.length) return Integer.MAX_VALUE;


        if (dp[i][v] != -1) return dp[i][v];


        long a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        if (v >= val[i]) a = wt[i] + Knapsack01Variation(wt, val, i + 1, v - val[i], dp);
        b = Knapsack01Variation(wt, val, i + 1, v, dp);

        return dp[i][v] = Math.min(a, b);
    }


    static int TrianleTopDown(List<List<Integer>> arr, int i, int j, int dp[][]) {  //leetcode 120
        if (i >= arr.size()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        a = arr.get(i).get(j) + TrianleTopDown(arr, i + 1, j, dp);
        b = arr.get(i).get(j) + TrianleTopDown(arr, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(a, b);
    }

    static int TriangelBottomUp(List<List<Integer>> arr) {
        int dp[][] = new int[205][205];


        for (int i = arr.size() - 1; i >= 0; i--) {
            for (int j = arr.get(i).size() - 1; j >= 0; j--) {
                int a = arr.get(i).get(j) + dp[i + 1][j];
                int b = arr.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(a, b);
            }
        }
        return dp[0][0];
    }

    int LISlongestincreasingsequence(int arr[]) {  //  leetcode 300
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            int ans = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) ans = Math.max(ans, dp[j]);
            }
            dp[i] = 1 + ans;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    static int ArithmeticSlice(int arr[]) {  // leetcode 413
        int n = arr.length;

        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else dp[i] = 0;
            ans = ans + dp[i];
        }
        return ans;
    }


    static int decodeways(String s, int i, int dp[]) {   // leetcode 91
        if (i >= s.length()) return 1;
        if (i == s.length() - 1) {
            if (s.charAt(i) != '0') return 1;
            else return 0;
        }

        if (dp[i] != -1) return dp[i];

        int a = 0, b = 0;
        if (s.charAt(i) != '0') a = decodeways(s, i + 1, dp);
        int x = Integer.valueOf(s.substring(i, i + 2));
        if (x >= 10 && x <= 26) b = decodeways(s, i + 2, dp);
        return dp[i] = a + b;
    }

    static void RoyAndCoinChangeAppraoch1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        int m = sc.nextInt();
        int st[] = new int[n + 1];
        int end[] = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            st[l]++;
            end[r]++;
        }

        arr[1] = st[1];
        for (int i = 2; i <= n; i++) {
            arr[i] = st[i] + arr[i - 1] - end[i - 1];
        }


//        2,3,2,1,2,1,0


        long count[] = new long[1000005];
        for (int i = 1; i <= n; i++) {
            count[arr[i]]++;
        }

        for (int i = n - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        int q = sc.nextInt();
        while (q > 0) {
            int x = sc.nextInt();
            System.out.println(count[x]);
            q--;
        }
    }

    static void RoyAndCoinChangeAppraoch2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            arr[l] += 1;
            arr[r + 1] -= 1;
        }

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }


//        2,3,2,1,2,1,0


        long count[] = new long[1000005];
        for (int i = 1; i <= n; i++) {
            count[arr[i]]++;
        }

        for (int i = n - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        int q = sc.nextInt();
        while (q > 0) {
            int x = sc.nextInt();
            System.out.println(count[x]);
            q--;
        }
    }


    static int matrixChainMultiplication(int arr[], int i, int j, int dp[][]) {
        if (j <= i) return Integer.MAX_VALUE;
        if (j - i == 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int a = matrixChainMultiplication(arr, i, k, dp);
            int b = matrixChainMultiplication(arr, k, j, dp);
            int c = arr[i] * arr[k] * arr[j];

            ans = Math.min(ans, a + b + c);
        }

        return dp[i][j] = ans;
    }

    static int MixtureSmoke(int arr[], int i, int j, int dp[][]) {    // SPOJ
        if (j <= i) return 0;
        if (j - i == 1) return arr[i] * arr[j];

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int a = MixtureSmoke(arr, i, k, dp);
            int b = MixtureSmoke(arr, k + 1, j, dp);
            int sum1 = 0;
            int sum2 = 0;

            for (int x = i; x <= k; x++) sum1 += arr[x];
            for (int x = k + 1; x <= j; x++) sum2 += arr[x];

            sum1 = sum1 % 100;
            sum2 = sum2 % 100;

            ans = Math.min(ans, a + b + (sum1 * sum2));
        }

        return dp[i][j] = ans;
    }

    static int uniquepath2(int i, int j, int arr[][], int dp[][]) {   // Leetcode 63
        int m = arr.length;
        int n = arr[0].length;
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;
        if (arr[i][j] == 1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int a = uniquepath2(i + 1, j, arr, dp);
        int b = uniquepath2(i, j + 1, arr, dp);

        return dp[i][j] = a + b;
    }

    static int minimumPathSum(int arr[][]) {   // Leetcode 64
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n + 1][m + 1];
        for (var a : dp) Arrays.fill(a, Integer.MAX_VALUE);
        dp[n - 1][m - 1] = arr[n - 1][m - 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    static long Deque(long arr[], int i, int j, long dp[][]) {   // Atcoder
        if (i == j) return arr[i];

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = Math.max(arr[i] - Deque(arr, i + 1, j, dp), arr[j] - Deque(arr, i, j - 1, dp));
    }


    static int tourist(String arr[][], int i, int j, int x, int y, int dp[][][]){    // i+j = x+y

        // SPOJ

        int n = arr.length;
        int m = arr[0].length;

        if(i>=n || j>=m || x>=n || y>=m || arr[i][j]=="#" || arr[x][y]=="#") return 0;
        if(i==n-1 && j==m-1){
            if(arr[i][j]=="*") return 1;
            else return 0;
        }

        if(dp[i][j][x]!=-1) return dp[i][j][x];

        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans,tourist(arr,i+1,j,x,y+1,dp));
        ans = Math.max(ans,tourist(arr,i+1,j,x+1,y,dp));
        ans = Math.max(ans,tourist(arr,i,j+1,x,y+1,dp));
        ans = Math.max(ans,tourist(arr,i,j+1,x+1,y,dp));


        if(arr[i][j]=="*") ans++;
        if(arr[x][y]=="*") ans++;

        if(i==x && j==y && arr[i][j]=="*") ans--;  //repetation

        return dp[i][j][x] = ans;
    }


    static double CoinsProbability(double arr[], int i, int x, double dp[][]){
        if(x<=0) return 1;
        if(i>=arr.length) return 0;

        if(dp[i][x]!=-1) return dp[i][x];

        double a = arr[i]*CoinsProbability(arr,i+1,x-1,dp);   // head
        double b = (1-arr[i])*CoinsProbability(arr,i+1,x,dp);    // tail
        return  dp[i][x] = a+b;
    }


    static double badLuckIsland(int r, int s, int p, double dp[][][]){    // codeforces

        if(p==0) return 1;
        if(r==0 || s==0) return 0;

        if(dp[r][s][p]>-0.9) return dp[r][s][p];

        double total = (r*s + r*p + s*p)*1.0;

        double a = badLuckIsland(r,s-1,p,dp)*((r*s)/total);
        double b = badLuckIsland(r-1,s,p,dp)*((r*p)/total);
        double c = badLuckIsland(r,s,p-1,dp)*((s*p)/total);

        return dp[r][s][p] = a+b+c;
    }






    public static void main(String[] args) {
        char arr[][] = {{'.', '*', '.', '*', '.'},
                {'*', '#', '#', '#', '.'},
                {'*', '.', '*', '.', '*'},
                {'.', '#', '#', '#', '*'},
                {'.', '*', '.', '*', '.'}};
        int n = arr.length;
        int m = arr[0].length;

    }
}
