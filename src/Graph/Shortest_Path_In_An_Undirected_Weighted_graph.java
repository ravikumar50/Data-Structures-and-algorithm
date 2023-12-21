package Graph;

import java.util.*;

public class Shortest_Path_In_An_Undirected_Weighted_graph {

    // this method is a brute force method in which we explore each and every
    // path in order to find the shortest path between source and destination

    static ArrayList<int[]> graph[];

    static void addEdge(int a, int b, int wt){
        graph[a].add(new int[]{b,wt});
        graph[b].add(new int[]{a,wt});
    }

    static void display(){

        for(int i=0; i<graph.length; i++){

            for(int j=0; j<graph[i].size(); j++){
                System.out.print(i+" -> ");
                int a[] = graph[i].get(j);
                System.out.println(a[0]+" "+a[1]);
            }
        }
    }

    static int ans;

    // DFS

    static void shortestPath(int src, int dest, int currAns, int visited[]){
        if(src==dest){
            ans = Math.min(ans,currAns);
            return;
        }

        for(var a : graph[src]) {
            if (visited[a[0]] != 1) {
                visited[a[0]] = 1;
                shortestPath(a[0], dest, currAns + a[1], visited);
                visited[a[0]] = -1;
            }
        }
    }

    public static void main(String[] args) {


        ans = Integer.MAX_VALUE;
        int edge[][] = {{0,1,1},{0,2,5},{1,2,4},{1,3,1},{2,4,1},{3,4,1},{3,6,2},{4,5,5},{6,5,1}};
        int v = 7;
        int e = edge.length;
        graph = new ArrayList[v];

        for(int i=0; i<v; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<e; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            int c = edge[i][2];
            addEdge(a,b,c);
        }

   //     display();

        int src=0;
        int dest=5;

        int visited[] = new int[v];
        Arrays.fill(visited,-1);
        visited[src] = 1;

        shortestPath(src, dest,0,visited);
        System.out.println(ans);
    }
}
