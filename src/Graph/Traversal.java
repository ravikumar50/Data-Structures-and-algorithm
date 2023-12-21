package Graph;
// 7 8 0 1 0 4 1 3 4 3 1 5 5 6 6 2 5 2
// 8 9 0 1 0 4 1 3 4 3 1 5 5 6 6 2 5 2 4 7

// DFS - Depth First Search


import java.util.*;

public class Traversal {

    static ArrayList<Integer> graph[];

    static HashSet<Integer> hp;


    static boolean anyPathFromSourceToDestination(int src, int dest){
        if(src==dest) return true;
        hp.add(src);

        for(var a : graph[src]){
            if(!hp.contains(a)){
                boolean result = anyPathFromSourceToDestination(a,dest);
                if(result) return result;
            }
        }
        return false;
    }

    static void allPathFromSourceToDestination(int src, int dest, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr){
        if(src==dest){
            arr.add(src);
            ArrayList<Integer> a = new ArrayList<>();
            for(var x : arr) a.add(x);
            ans.add(a);
            arr.remove(arr.size()-1);
            return;
        }
        hp.add(src);
        arr.add(src);
        for(var a : graph[src]){
            if(!hp.contains(a)){
                allPathFromSourceToDestination(a,dest,ans,arr);

            }
        }
        arr.remove(arr.size()-1);
        hp.remove(src);
        return;
    }

    static void DFS(int src){
        hp.add(src);
        for(var a : graph[src]){
            if(!hp.contains(a)){
                DFS(a);
                hp.add(a);
            }
        }
    }

    static void levelOrderBFS(int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        HashSet<Integer> hp = new HashSet<>();
        hp.add(src);
        while(q.size()!=0){
            int parent = q.remove();
            for(var a : graph[parent]){
                if(!hp.contains(a)){
                    q.add(a);
                    hp.add(a);
                }
            }
            System.out.print(parent+" ");
        }
    }

    static void shortestDistanceBetweenTwoNodes(int src){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hp = new HashSet<>();
        q.add(src);

        int dist[] = new int[graph.length];
        dist[src] = 0;

        while(q.size()>0){
            int parent = q.remove();

            for(var a : graph[parent]){
                if(!hp.contains(a)){
                    q.add(a);
                    hp.add(a);
                    dist[a] = dist[parent]+1;
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
    }

    static void addEdge(int src, int dest, boolean bi_dir){
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
        graph = new ArrayList[v];
        hp = new HashSet<>();

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        int e = sc.nextInt();
        while(e>0){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            addEdge(src,dest,false);
            e--;
        }

       // display(graph);

        levelOrderBFS(0);
        //shortestPathBetweenTwoNodes(0);
    }
}
