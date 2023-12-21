package Graph;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class Question {

    static ArrayList<Integer> graph[];

    static void addEdge(int src, int dest, boolean bi_dir){
        graph[src].add(dest);
        if(bi_dir){
            graph[dest].add(src);
        }
    }



    static int connected(){

        HashSet<Integer> hp = new HashSet<>();
        int ans = 0;
        for(int i=0; i<graph.length; i++){
            // go to every vertex
            // if we can initialize dfs we can have new connected component

            if(!hp.contains(i)){
                ans++;
                dfs(i,hp);
            }
        }
        System.out.println(hp);
        return ans;
    }

    static void dfs(int node, HashSet<Integer> hp){
        hp.add(node);

        for(var a : graph[node]){
            if(!hp.contains(a)){
                dfs(a,hp);
            }
        }
    }

    static void floodFill(int arr[][], int a, int b, int initialcol, int newCol){  // leetcode 733
        int n = arr.length;
        int m = arr[0].length;

        if(a<0 || b<0 || a>=n || b>=m) return;

        if(arr[a][b]!=initialcol) return;

        arr[a][b] = newCol;

        floodFill(arr,a,b+1,initialcol,newCol);
        floodFill(arr,a,b-1,initialcol,newCol);
        floodFill(arr,a-1,b,initialcol,newCol);
        floodFill(arr,a+1,b,initialcol,newCol);
    }

    static void numberOfIsland(char arr[][], int i, int j, int visited[][]){  // leetcode 200
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length) return;

        if(visited[i][j]==1 || arr[i][j]=='0') return;

        visited[i][j] = 1;
        numberOfIsland(arr,i,j+1,visited);
        numberOfIsland(arr,i,j-1,visited);
        numberOfIsland(arr,i-1,j,visited);
        numberOfIsland(arr,i+1,j,visited);
    }

    static List<List<Integer>> pacificAtlantic(int[][] arr) {  // Leetcode
        int n = arr.length;
        int m = arr[0].length;

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q1.add(new int[]{i, 0});
            q2.add(new int[]{i, m - 1});
        }
        for (int j = 1; j < m; j++) {
            q1.add(new int[]{0, j});
        }
        for (int j = 0; j < m - 1; j++) {
            q2.add(new int[]{n - 1, j});
        }

        int visited1[][] = bfsOcean(arr,q1);
        int visited2[][] = bfsOcean(arr,q2);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] == 1 && visited2[i][j] == 1) {
                    List<Integer> ar = List.of(i, j);
                    ans.add(ar);
                }
            }
        }

        return ans;
    }

    static int[][] bfsOcean(int arr[][], Queue<int[]> q){

        int n = arr.length;
        int m = arr[0].length;
        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        int visited[][] = new int[n][m];

        while(q.size()!=0){
            int a[] = q.remove();
            int i = a[0];
            int j = a[1];
            visited[i][j] = 1;
            int h = arr[i][j];

            for(int k=0; k<4; k++){
                int newR = i+dir[k][0];
                int newC = j+dir[k][1];

                if(newR<0 || newC<0 || newR>=n || newC>=m || visited[newR][newC]==1) continue;
                if(arr[newR][newC]>=h) q.add(new int[]{newR,newC});
            }
        }

        return visited;
    }


    static int orangesRotting(int[][] arr) {   // Leetcode 994
        int n = arr.length;
        int m = arr[0].length;

        Queue<int[]> q = new LinkedList<>();
        fresh = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) q.add(new int[]{i, j});
                else if (arr[i][j] == 1) fresh++;
                else zero++;
            }
        }
        if (zero == m * n) return 0;
        int ans = bfsOrange(q,arr);

        if (fresh == 0) return ans - 1;
        else return -1;
    }

    static int fresh;

    static int bfsOrange(Queue<int[]> q, int arr[][]){

        int ans = 0;
        int n = arr.length;
        int m = arr[0].length;

        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        while(q.size()!=0){
            int x = q.size();

            for(int l=0; l<x; l++){
                int a[] = q.remove();
                int i = a[0];
                int j = a[1];
                arr[i][j]=2;

                for(int k=0; k<4; k++){
                    int newR = i+dir[k][0];
                    int newC = j+dir[k][1];

                    if(newR<0 || newC<0 || newR>=n || newC>=m || arr[newR][newC]==0 || arr[newR][newC]==2) continue;

                    fresh--;
                    arr[newR][newC] = 2;
                    q.add(new int[]{newR,newC});
                }
            }
            ans++;
        }
        return ans;
    }

    static int[][] zeroOneMatrix(int arr[][]){      // leetcode 542
        int n = arr.length;
        int m = arr[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    arr[i][j] = -1;
                }
            }
        }

        bfsZeroOneMatrix(q,arr);
        return arr;
    }

    static int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};


    static void bfsZeroOneMatrix(Queue<int[]> q, int arr[][]){
        int n = arr.length;
        int m = arr[0].length;

        while(q.size()!=0){
            int a[] = q.poll();
            int r = a[0];
            int c = a[1];
            for(int k=0; k<4; k++){
                int nr = r+dir[k][0];
                int nc = c+dir[k][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && arr[nr][nc]==-1){
                    arr[nr][nc] = arr[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }

    static String[][] surroundedRegion(String arr[][]){   // leetcode 130
        int n = arr.length;
        int m = arr[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(arr[i][0]=="O"){
                q.add(new int[]{i,0});
            }
            if(arr[i][m-1]=="O"){
                q.add(new int[]{i,m-1});
            }
        }

        for(int j=1; j<m-1; j++){
            if(arr[0][j]=="O") q.add(new int[]{0,j});
            if(arr[n-1][j]=="O") q.add(new int[]{n-1,j});
        }


        q.add(new int[]{0,0});

        bfsSurroundedRegion(q,arr);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]=="Y") arr[i][j]="O";
                else if(arr[i][j]=="O") arr[i][j] = "X";
            }
        }

        return arr;

    }

    static void bfsSurroundedRegion(Queue<int[]> q, String arr[][]){

        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        int n = arr.length;
        int m = arr[0].length;

        while(q.size()!=0){
            int a[] = q.remove();
            int i = a[0];
            int j = a[1];
            arr[i][j]="Y";

            for(int k=0; k<4; k++){
                int nr = i+dir[k][0];
                int nc = j+dir[k][1];

                if(nr>=0 && nc>=0 && nr<n && nc<m && arr[nr][nc]=="O"){
                    arr[nr][nc]="Y";
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        int e = sc.nextInt();
        while(e>0){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            addEdge(src,dest,false);
            e--;
        }

        System.out.println(connected());





    }
}
