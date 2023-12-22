package Graph;

import java.util.*;
public class Question_On_Dijkstra_0_1_BFS {
    // Leetcode 1368

    /* In this Question we have the weight which either 0 or 1. So we will
       deque instead of Priority Queue as there is only two types of weight
       we will push 0 weight in front and 1 weigth at last and will do the
       normal bfs to find the shortest path
       T.C = O(V+E) as we are not using Priority Queue.
    */

    static int helper(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        int dist[][] = new int[n][m];
        for(var a : dist) Arrays.fill(a,Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dq.addFirst(new int[]{0,0});  // cordinates added
        dist[0][0] = 0;

        while(dq.size()!=0){
            int a[] = dq.removeFirst();
            int x = a[0];
            int y = a[1];

            int dir = arr[x][y];

            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                int wt = 1;
                if(k+1==dir) wt = 0;
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(dist[nx][ny]>dist[x][y]+wt){
                        dist[nx][ny]=dist[x][y]+wt;
                        if(wt==1) dq.addLast(new int[]{nx,ny});
                        else dq.addFirst(new int[]{nx,ny});
                    }
                }
            }

        }
        return dist[n-1][m-1];
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};


        System.out.println(helper(arr));
    }


}
