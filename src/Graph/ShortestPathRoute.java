package Graph;

import java.util.*;

public class ShortestPathRoute {

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
        System.out.println();
    }

    static int shortestDistanceBetweenSrcAndDest(int src, int dest){
        Queue<int[]> q = new LinkedList<>();
        int visited[] = new int[graph.length];

        Arrays.fill(visited,-1);
        q.add(new int[]{src,0});
        visited[src] = 1;

        while(q.size()!=0){
            int a[] = q.remove();
            int num = a[0];
            int steps = a[1];
            if(num==dest) return steps;

            for(var x : graph[num]){
                if(visited[x]!=1){
                    q.add(new int[]{x,steps+1});
                    visited[x] = 1;
                }
            }
        }
        return -1;
    }


    static int[] shortestDistanceArrayFromAParticularNode(int src){
        Queue<int[]> q = new LinkedList<>();
        int visited[] = new int[graph.length];
        int ans[] = new int[graph.length];

        Arrays.fill(visited,-1);
        q.add(new int[]{src,0});
        visited[src] = 1;
        ans[src] = 0;

        while(q.size()!=0){
            int a[] = q.remove();
            int num = a[0];
            int steps = a[1];
            ans[num] = steps;

            for(var x : graph[num]){
                if(visited[x]!=1){
                    q.add(new int[]{x,steps+1});
                    visited[x] = 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int v = 7;
        int e = 9;

        int arr[][] = {{0,2},{0,1},{2,4},{3,1},{3,4},{0,3},{3,5},{4,5},{5,6}};

        graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            addEdge(arr[i][0],arr[i][1]);
        }

        int src = 0;
        int dest = 6;
        int visited[] = new int[v];
        Arrays.fill(visited,-1);

        int d = shortestDistanceBetweenSrcAndDest(src,dest);
        int d1[] = shortestDistanceArrayFromAParticularNode(src);
        int d2[] = shortestDistanceArrayFromAParticularNode(dest);

        // given below code will print the node that will comes atleast one time in the
        // shortest path between src and dest

        for(int i=0; i<d1.length; i++){
            if(d1[i]+d2[i]==d){
                System.out.print(i+" ");
            }
        }

    }
}