package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ImplentationAdjacencyMap {

    // undirecte weighted graph

    static void addEdge(int src, int dest, int wt, boolean bi_dir, HashMap<Integer,Integer> graph[]){
        graph[src].put(dest,wt);
        if(bi_dir){
            graph[dest].put(src,wt);
        }
    }

    static void display(HashMap<Integer,Integer> graph[]){
        for(int i=0; i< graph.length; i++){
            System.out.print(i+"-> ");
            System.out.println(graph[i]);
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        HashMap<Integer,Integer> graph[] = new HashMap[v];
        for(int i=0; i<v; i++){
            graph[i] = new HashMap<>();
        }
        int e = sc.nextInt();
        while(e>0){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            addEdge(src,dest,wt,true,graph);
            e--;
        }
        display(graph);
    }
}
