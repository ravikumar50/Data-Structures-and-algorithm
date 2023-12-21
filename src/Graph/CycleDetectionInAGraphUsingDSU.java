package Graph;

// We have seen that how we can find cycle in a directed graph using topological sorting
// or also called Kahn's algorithm but what about finding the cycle in an undirected graph

// In this section we will learn how to find a cycle in an undirected graph

// Now this can be solved using three methods which are BFS,DFS,DSU

// BFS/DFS methods can be used but we will see that later
// We will use DSU to find the cycle detection in this section

// What we will do is that we have been given the edge list and we iterate through those
// edge list and put the node the group
// Now if two nodes share the same parent that means there already exixts a path between
// them and we are trying to add one more path between them which means that there is a
// cycle exixts otherwise there is no cycle in the graph



public class CycleDetectionInAGraphUsingDSU {

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
        int edgeList[][] = {{0,1},{0,2},{0,3},{3,4},{3,6},{4,5},{5,6},{6,7},{7,8},{7,9}};

        int v = 10;
        int e = 10;

        par = new int[v];
        rank = new int[v];

        for(int i=0; i<v; i++){
            par[i] = i;
        }

        for(int i=0; i<e; i++){
            int a = edgeList[i][0];
            int b = edgeList[i][1];

            if(find(a)==find(b)){
                System.out.println("There exist a cycle in the graph");
                return;
            }else{
                union(a,b);
            }
        }

        // The T.C will be e*(log*n) which almost equal to e, where e is the number of edge

        System.out.println("There is no cycle in the graph");
    }
}
