package Tries;

import java.util.*;

public class Practice {

    static int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static boolean isEqual(int arr1[][], int arr2[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }

    static void swap(int arr[][], int r1, int c1, int r2, int c2) {
        int a = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = a;
    }

    static void dfs(int arr1[][], int arr2[][], int row, int col, ArrayList<int[][]> ans, int visited[][]) {
        if (isEqual(arr1, arr2)) {
            // display the steps
            for (int k = 0; k < ans.size(); k++) {
                int arr[][] = ans.get(k);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        visited[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            if (nr >= 0 && nc >= 0 && nr < 3 && nc < 3 && visited[nr][nc] != 1) {
                swap(arr1, row, col, nr, nc);
                ans.add(copyArray(arr1));
                dfs(copyArray(arr1), arr2, nr, nc, ans, visited);
                ans.remove(ans.size() - 1);
                swap(arr1, row, col, nr, nc);
            }
        }
        visited[row][col] = -1;
    }

    static int[][] copyArray(int arr[][]) {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        int arr1[][] = {{1, 2, 3},
                        {0, 4, 6},
                        {7, 5, 8}};
        int arr2[][] = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 0}};

        int visited[][] = new int[3][3];
        for (int a[] : visited) Arrays.fill(a, -1);
        ArrayList<int[][]> ans = new ArrayList<>();
        ans.add(copyArray(arr1));
        dfs(copyArray(arr1), arr2, 1, 0, ans, visited);
    }
}
