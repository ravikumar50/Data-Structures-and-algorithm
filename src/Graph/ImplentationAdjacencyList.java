package Graph;


// Adjacency List - In this approach we will implement graph as the Array of Linked List

// Adjacency Map - In this approach we will implement graph as the Array of HashMap

// Adjacency Matrix - In this appraoch we represent graph in a 2d array of v*v dimenstion where v is the number of vertex
   // arr[i][j] = 1 then there is an edge between i to j and if arr[i][j] = 0 then there is no edge between i to j

import java.util.ArrayList;
import java.util.Scanner;

// Incidence Matrix - In this approach we represent graph in a 2d array of v*e dimension where v is the number of vertex
// and e is the number of edge
//    arr[i][j] = 1 then ith vertex belongs to jth edge and if arr[i][j] = 0 then the ith does not belongs to jth edge


public class ImplentationAdjacencyList {

    // undirected unweighted graph
    static void addEdge(int src, int dest, boolean bi_dir, ArrayList<Integer> graph[]){
        graph[src].add(dest);
        if(bi_dir){
            graph[dest].add(src);
        }
    }

    static void display(ArrayList<Integer> graph[]){
        for(int i=0; i< graph.length; i++){
            System.out.print(i+"-> ");
            System.out.println(graph[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        int e = sc.nextInt();
        while(e>0){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            addEdge(src,dest,true,graph);
            e--;
        }
        display(graph);

    }
}
