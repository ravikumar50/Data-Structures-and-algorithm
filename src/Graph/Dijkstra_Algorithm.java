package Graph;
import java.lang.reflect.Array;
import java.util.*;
public class Dijkstra_Algorithm {

    // This Algorithm is used to find the shortest path between a source node and the
    // destination node in a weighted graph

    // This Algorithm uses the same method that is used in the Prim's Alogorithm with a slight change in it

    /*  Steps

     1. Take a PriorityQueue which will contains the node and the shortest distance
        between the source and that node and the comparision will be on the basis of
        the distance.
     2. Take an array 'ans' which will contains the shortest distance of each node from
        source and nodes which are visited. Take another visited array
     3. Push the source with distance 0 in the PriorityQueue as the distance of source from
        source is always 0
     4. Fill the ans array with Max value except the source node and put
        ans[src] = 0
     5. Mark all the nodes -1 except the source node in the visited array and put
        visited[src] = 1;
     6. Now remove the elements from PriorityQueue and mark that node visited
     7. Now go to all the neighbours of the that node which are not visited and compare
        the distance of that node in 'ans' array with the distance through this node
        if it is smaller than that then replace the distance with new distance
     8. Push the neighbour in the PriorityQueue with right distance
     9. Repeat the process 6,7,8 until the PriorityQueue is not empty


     */

    static ArrayList<int[]> graph[];

    static void addEdge(int a, int b, int wt){
        graph[a].add(new int[]{b,wt});
        graph[b].add(new int[]{a,wt});
    }

    static class edgeComparator implements Comparator<int[]>{
        public int compare(int a[], int b[]){
            return a[1]-b[1];
        }
    }

    public static void main(String[] args) {
       // int edge[][] = {{0,1,1},{0,2,5},{1,2,4},{1,3,1},{2,4,1},{3,4,1},{3,6,2},{4,5,5},{6,5,1}};
        int edge[][] = {{0,1,7},{0,2,2},{1,3,2},{2,3,1},{2,4,2},{4,5,5},{5,6,1},{4,6,3}};
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

        int start = 0;
        int dest = 5;

        int visited[] = new int[v];
        int ans[] = new int[v];
        int via[] = new int[v];  // optional
        Arrays.fill(ans,Integer.MAX_VALUE);
        Arrays.fill(visited,-1);
        ans[start] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>(new Prims_Algorithm.weightComparator());

        pq.add(new int[]{start,0});
        visited[start] = 1;

        while(pq.size()!=0){     // T.C (V+E)*LogV
            int a[] = pq.remove();
            visited[a[0]] = 1;

            for(var x : graph[a[0]]){
                if(visited[x[0]]!=1 && ans[x[0]]>ans[a[0]]+x[1]){
                    ans[x[0]] = ans[a[0]]+x[1];
                    via[x[0]] = a[0];
                    pq.add(new int[]{x[0],ans[x[0]]});
                }
            }
        }


        for(int i=0; i<v; i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
//        for(int i=0; i<v; i++){
//            System.out.print(via[i]+" ");
//        }

    }
}
