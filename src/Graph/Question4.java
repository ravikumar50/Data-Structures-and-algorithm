package Graph;

import java.util.Arrays;

public class Question4 {

    // leetcode - 1559
    // cycle detection in a 2D grid

    static int n;
    static int m;

    static boolean dfs(int r, int c, int parI, int parJ,int visited[][], String arr[][]){

        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        visited[r][c]=1;
        boolean ans = false;

        for(int i=0; i<4; i++){
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && arr[nr][nc]==arr[r][c]){
                if(visited[nr][nc]==1 && nr!=parI && nc!=parJ) return true;
                if(visited[nr][nc]!=1) ans = ans || dfs(nr,nc,r,c,visited,arr);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String arr[][] = {{"a","a","a","a"},
                {"a","b","b","a"},
                {"a","b","b","a"},
                {"a","a","a","a"}};
        n = arr.length;
        m = arr[0].length;

        int visited[][] = new int[n][m];
        for(var a : visited) Arrays.fill(a,-1);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]!=1){
                    boolean ans = dfs(i,j,-1,-1,visited,arr);
                    if(ans==true){
                        System.out.println("Cycle detected");
                        return;
                    }
                }
            }
        }
        System.out.println("No Cycle Present");
    }
}
