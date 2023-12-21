package Graph;

import java.util.*;


// In this section we will learn how to find a cycle in a graph using DFS

// We will do a normal dfs and also take a visited array
// Now the crucks of this problem is that we will call a dfs only if it is not visited
// and it is also not the parent of that node

// Now if the next node is visited and it is also not the parent of the current node then there is cycle that exist
// in the graph
// So we will also pass a extra variable which will represent the parent of that node


public class CycleDetectionUsingDFS {

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

    static boolean dfs(int src, int parent, int visited[]){
        visited[src] = 1;
        boolean ans = false;

        for(var x : graph[src]){
            if(visited[x]==1 && x!=parent){
                return true;
            }

            if(visited[x]!=1){
                visited[x]=1;
                ans = ans || dfs(x,src,visited);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int edgeList[][] = {{0,1},{1,2},{1,3},{3,0}};
        int v = 4;
        int e = edgeList.length;

        graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++) addEdge(edgeList[i][0],edgeList[i][1]);

        //display();
        int visited[] = new int[v];


        for(int i=0; i<v; i++){
            if(visited[i]!=1){
                boolean ans = dfs(i,-1,visited);
                if(ans==true){
                    System.out.println("Cycle detected");
                    return;
                }
            }
        }
        System.out.println("No cycle found");
    }
}
