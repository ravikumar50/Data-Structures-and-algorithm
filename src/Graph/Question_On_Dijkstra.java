package Graph;

import java.util.*;

// leetcode 1631

/*
You are a hiker preparing for an upcoming hike. You are given heights,
a 2D array of size rows x columns, where heights[row][col] represents
 the height of cell (row, col). You are situated in the top-left cell,
 (0, 0), and you hope to travel to the bottom-right cell, (rows-1,
 columns-1) (i.e., 0-indexed). You can move up, down, left, or right,
 and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two
 consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to
the bottom-right cell.
 */
public class Question_On_Dijkstra {

    public static class wtComparator implements Comparator<int[]>{
        public int compare(int a[], int b[]){
            return a[0]-b[0];
        }
    }

    public static int minimumEffortPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new wtComparator());

        int dist[][] = new int[n][m];
        for(var a : dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.add(new int[]{0,0,0});

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(pq.size()!=0){
            int a[] = pq.remove();
            int x = a[1];
            int y = a[2];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    int newdist = Math.max(dist[x][y],Math.abs(arr[x][y]-arr[nx][ny]));
                    if(newdist<dist[nx][ny]){
                        dist[nx][ny] = newdist;
                        pq.add(new int[]{newdist,nx,ny});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,2},{3,8,2},{5,3,5}};

        System.out.println(minimumEffortPath(arr));
    }
}
