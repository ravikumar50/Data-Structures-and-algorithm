package Graph;

import javax.lang.model.type.IntersectionType;
import java.util.*;

// There is a undirected and unweighted graph with edges of color either blue or red
// find the shortest distance between the source and the destination having the following constrans
// 1. The path should start with red edge and must end with blue edge
// 2. You can shift from red edge to blue edge only once. You cannot shift from blue to red edge
// 3. There are no self loops and mutiple edges


// Solution

// The approach is very simple.
// We will take each node as intermediate node except the src and dest and will find the
// distance of each node from the source with a particular color using bfs.
// we will call bfs two times , 1st one for the src to dest and 2nd one for dest to src
// then we will calculate the minumum distance by adding the individual ditances at each node
// except for the src and dest node.
public class Question1 {

    static class Pair{
        int num;
        String col;

        Pair(int num, String col){
            this.num = num;
            this.col = col;
        }
    }

    static ArrayList<Pair> graph[];

    static int min;

    static void addEdge(int a, int b, String color){
        graph[a].add(new Pair(b,color));
        graph[b].add(new Pair(a,color));
    }

    static void display(){
        for(int i=0; i<graph.length; i++){
            System.out.print(i+"-> ");
            ArrayList<Pair> x = graph[i];
            for(int j=0; j<x.size(); j++){
                System.out.print(x.get(j).num+" "+x.get(j).col+" ");
            }
            System.out.println();
        }
    }

    static void solve(int src, int des, int visited[], String color, int distance[]){
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = 1;
        distance[src] = 0;

        while(q.size()!=0){
            int a = q.remove();
            if(a==des) continue;

            for(var x : graph[a]){
                if(x.col.equals(color) && visited[x.num]!=1){
                    distance[x.num]=distance[a]+1;
                    q.add(x.num);
                    visited[x.num] = 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = 7;
        int e = 9;
        min = Integer.MAX_VALUE;

        int arr[][] = {{0,2},{0,1},{2,4},{3,1},{3,4},{0,3},{3,5},{4,5},{5,6}};

        graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<4; i++){
            addEdge(arr[i][0],arr[i][1],"R");
        }

        for(int i=4; i<e; i++){
            addEdge(arr[i][0],arr[i][1],"B");
        }

        int visited[] = new int[v];
        int d1[] = new int[v];
        int d2[] = new int[v];
        for(int i=0; i<v; i++){
            visited[i] = -1;
            d1[i] = d2[i] = 1000000;
        }

        int src = 6;
        int des = 5;

        solve(src,des,visited,"R",d1);
        Arrays.fill(visited,-1);
        solve(des,src,visited,"B",d2);

        long ans = 1000000;

        for(int i=0; i<v; i++){
            if(i==src || i==des) continue;
            ans = Math.min(d1[i]+d2[i],ans);
        }

        System.out.println(ans);
    }
}
