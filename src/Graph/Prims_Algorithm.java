
package Graph;
import java.util.*;

import java.util.Scanner;

// use this algorithm when the number of edges are more than the number of vertexes in the graph

public class Prims_Algorithm {


// Prim's Algorithm is a method of finding the MST(Minimum Spanning Tree)

    // In Prim's , we start with a source node and try to discover other nodes.

    // At initial stage all the nodes except the source node will have infinity
    // discovery weight ans source node will have 0 discovery weight

    // We will use a priority queue instead of queue to process the nodes.

    /* Steps

    1. First take a priority queue of array which contains the node and their weight and comparision will be
       on the basis of their weight
    2. Push the source node with weight = 0 in the priority queue.
    3. Also create an 'ans' array that will contain the minimum weight of each node
       and initialise that array with maximum value except the source node and give source node value as -1
    4. Also take a visited array and mark source as visited at the begining.
    5. Now remove the element from the PriorityQueue and compare the weight of that node from the
       node in the ans array , if the weight is less that the node in the ans array
       then update the weight in the ans array 'ans' push the node in the priority
       queue with the updated weight.
    6. Make the removed node as visited in the visited array.
    7. Now go to the every neighbour of the removed node and if the neighbour node
       is not visited then add that node with their weight in the priority queue.
    8. Repeat the process 5,6,7 until the priority queue is not empty.
     */

    static ArrayList<int[]> graph[];

    static void addEdge(int src, int dest, int wt) {
        graph[src].add(new int[]{dest, wt});
        graph[dest].add(new int[]{src, wt});
    }

    public static class weightComparator implements Comparator<int[]> {
        public int compare(int a[], int b[]) {
            return a[1] - b[1];
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            addEdge(a - 1, b - 1, c);
        }

        int start = sc.nextInt();
        start = start-1;

        int visited[] = new int[n];
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        Arrays.fill(visited,-1);
        ans[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new weightComparator());

        pq.add(new int[]{start,0});
        visited[start] = 1;


        while(pq.size()!=0){
            int a[] = pq.remove();
            visited[a[0]] = 1;
            for(var x : graph[a[0]]){
                if(visited[x[0]]!=1 && ans[x[0]]>x[1]){
                    ans[x[0]] = x[1];
                    pq.add(new int[]{x[0],x[1]});
                }
            }
        }


        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum+ans[i];
        }

        System.out.println(sum);

    }
}

