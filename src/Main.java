import java.util.*;

class Solution {
    public int numMagicSquaresInside(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                HashSet<Integer> hp = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (arr[k][l] >= 1 && arr[k][l] <= 9) hp.add(arr[k][l]);
                    }
                }

                if (hp.size() == 9) {
                    HashSet<Integer> sum = new HashSet<>();
                    for (int k = i; k < i + 3; k++) {
                        int s = 0;
                        for (int l = j; l < j + 3; l++) {
                            s += arr[k][l];
                        }
                        sum.add(s);
                    }

                    for (int l = j; l < j + 3; l++) {
                        int s = 0;
                        for (int k = i; k < i + 3; k++) {
                            s += arr[k][l];
                        }
                        sum.add(s);
                    }
                    sum.add(arr[i][j] + arr[i + 1][j + 1] + arr[i + 2][j + 2]);
                    sum.add(arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]);
                    if (sum.size() == 1) ans++;
                }


            }
        }
        return ans;
    }
}
