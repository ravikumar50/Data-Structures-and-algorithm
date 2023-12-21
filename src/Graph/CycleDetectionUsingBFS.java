package Graph;

import java.util.*;

// In this section we will learn how to find cycle in a graph using BFS

// We will do a normal bfs and before pushing any element into the queue we will check that if the
// if the element is present in the queue already or not , if it is present there must be a cycle in
// the graph otherwise there is no cycle in the graph


public class CycleDetectionUsingBFS {

    static ArrayList<Integer> graph[];

    static void addEdge(int a, int b){
        graph[a].add(b);
        graph[b].add(a);
    }

    static void display(){
        for(int i=0; i<graph.length; i++){
            System.out.print(i+"-> ");
            System.out.println(graph[i]);
        }
    }

    static boolean bfs(int src){
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[graph.length];
        Arrays.fill(visited,-1);
        q.add(src);
        visited[src] = 1;

        while(q.size()!=0){
            int a = q.remove();
            visited[a] = 1;

            for(var x : graph[a]){
                if(q.contains(x)) return true;
                if(visited[x]!=1){
                    q.add(x);
                    visited[x] = 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int edgeList[][] = {{0,1},{0,2},{0,3},{3,4},{4,5},{5,6},{6,7},{7,8},{7,9}};

        int v = 10;
        int e = edgeList.length;

        graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++) addEdge(edgeList[i][0],edgeList[i][1]);

        for(int i=0; i<v; i++){
            boolean ans = bfs(i);
            if(ans==true){
                System.out.println("Cycle detected");
                return;
            }
        }
        System.out.println("No cycle is Present");
    }
}
