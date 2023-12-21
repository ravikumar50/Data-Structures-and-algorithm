package Graph;
import java.util.*;
public class Question2 {

    // leetcode 947

    // this question is of finding the number of connected component
    // just find the number of connected component using DFS/BFS or
    // using DSU
    // your answer will be number of stones - number of connected component
    // because from each connected component you can pick each and every
    // stone except the last one.

    static ArrayList<Integer> graph[];

    static void addEdge(int a, int b){
        graph[a].add(b);
        graph[b].add(a);
    }

    static void bfs(int src, int visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = 1;

        while(q.size()!=0){
            int a = q.remove();
            visited[a] = 1;
            for(var x : graph[a]){
                if(visited[x]!=1){
                    visited[x]=1;
                    q.add(x);
                }
            }
        }
    }

    static int stoneRemover(int arr[][]){
        int v = arr.length;

        graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<v; i++){
            int x1 = arr[i][0];
            int y1 = arr[i][1];
            for(int j=i+1; j<v; j++){
                int x2 = arr[j][0];
                int y2 = arr[j][1];

                if(x1==x2 || y1==y2){
                    addEdge(i,j);
                }
            }
        }

        int visited[] = new int[v];
        Arrays.fill(visited,-1);
        int connected = 0;
        for(int i=0; i<v; i++){
            if(visited[i]!=1){
                connected++;
                bfs(i,visited);
            }
        }
        return v-connected;
    }

    public static void main(String[] args) {

        int arr[][] = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        System.out.println(stoneRemover(arr));
    }

}
