package Graph;
import java.util.*;

// here we will find whether a cycle exits in a Directed graph or not
// this is also called topological sort

// indegree = no of incoming edge
// outdegree = no of outgoing edge


public class DAG_Or_Kahns_Algorithm_TopologicalSorting {

    // first we have to create a Directed  graph;

    static int v;
    static int e;

    static ArrayList<Integer> graph[];

    static void addEdge(int a, int b){
        graph[b].add(a);
    }

    static void display(){
        for(int i=0; i< graph.length; i++){
            System.out.print(i+"-> ");
            System.out.println(graph[i]);
        }
    }


    // Below is a question from leetcode i.e course schedule
    // leetcode - 207
    // this question also solve the problem of finding the cycle in given directed graph


    public static void main(String[] args) {

        int pre[][] = {{2,0},{2,1},{3,2},{3,1},{4,2},{6,4},{2,6},{6,5},{5,2},{5,3},{7,6}};
        v = 8;
        e = pre.length;
        graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i< pre.length; i++){
            addEdge(pre[i][0],pre[i][1]);
        }

        int indegree[] = new int[v];
        for(int i=0; i< pre.length; i++){
            indegree[pre[i][0]]++;
        }


        Queue<Integer> q = new LinkedList<>();

        int order[] = new int[v];
        int idx = 0;
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0) q.add(i);
        }

        if(q.size()==0){
            System.out.println("Cannot be completed as all are dependend on each other");
            return;
        }
        while (q.size()!=0){
            int a = q.remove();
            order[idx++] = a;
            for(var x : graph[a]){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }

        if(idx!=v){
            System.out.println("Cannot be completed as there is a cycle found");
            return;
        }else{
            System.out.print("The Order is : ");
            for(int i=0; i<order.length; i++) {
                System.out.print(order[i] + " ");
            }
        }
    }
}
