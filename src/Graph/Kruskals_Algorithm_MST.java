package Graph;

import java.util.*;

import java.util.Scanner;

// use this algorithm when the number of vertexes is more than the number of edges in the graph
public class Kruskals_Algorithm_MST {


    // In this section we will learn how to find a minimum spanning tree
    // MST can be find in two ways , the first one is using Kruskal's Algorithm
    // and the second one is using the prims algorithm

    // Here we will use Kruskal's algorithm to find the MST

    // Now the most simplest way to implement is using the DSU
    // First of all sort the edge list and consider only those edges which will not
    // create a cycle in the graph which can be checked using DSU



    static int par[];
    static int rank[];

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return;
        if(rank[a]>=rank[b]){
            par[b] = a;
            rank[a]++;
        }else {
            par[a] = b;
            rank[b]++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();



        int[][] edge = new int[e][3];
        par = new int[v];
        rank = new int[v];

        for(int i=0; i<v; i++){
            par[i] = i;
        }

        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edge[i] = new int[]{a,b,c};
        }

        Arrays.sort(edge,(a,b)->a[2]-b[2]);

        int sum = 0;
        // also check for the connected components , if connected component is more than 1 then there
        // is no way of connecting all the vertex



        for(int i=0; i<e; i++){
            int a = edge[i][0];
            int b = edge[i][1];

            if(find(a)!=find(b)){
                union(a,b);
                sum = sum + edge[i][2];
            }
        }

        int connected = 0;

        for(int i=0; i<par.length; i++){
            if(par[i]==i) connected++;
        }

        if(connected>1){
            System.out.println("Cannot find minimum cost as the graph is disconneted");
            return;
        }

        System.out.println(sum);
    }
}
