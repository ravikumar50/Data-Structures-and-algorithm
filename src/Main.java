import java.util.*;

public class Main
{

    static ArrayList<int[]> graph[];

    static void addEdge(int a, int b, int wt){
        graph[a].add(new int[]{b,wt});
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Nodes");
        int n = sc.nextInt();
        System.out.println("Enter the number of Pairs");

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        int m = sc.nextInt();
        System.out.println("Enter the Pairs along with their cost");
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int wt = sc.nextInt();
            addEdge(a,b,wt);
        }
        System.out.println("Enter the source node");
        int src = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int ans[] = new int[n];
        int visited[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        Arrays.fill(visited,-1);
        pq.add(new int[]{src,0});
        ans[src] = 0;
        visited[src] = 1;

        while(pq.size()!=0){
            int a[] = pq.remove();
            visited[a[0]] = 1;

            for(var x : graph[a[0]]) {
                if (visited[x[0]] != 1 && ans[x[0]] > ans[a[0]]+x[1]) {
                    ans[x[0]] = ans[a[0]]+x[1];
                    pq.add(new int[]{x[0], ans[x[0]]});
                }
            }
        }

        System.out.println("Shortest distance of each node from source node is ");

        for(int i=0; i<n; i++){
            System.out.print(ans[i]+" ");
        }
    }
}



/*

number of nodes = 5;
number of pairs = 9;

Pairs along with their cost

0 1 3
0 2 8
0 4 -4
1 3 1
1 4 2
2 1 4
2 3 2
3 4 9
3 6 2
3 7 1
4 5 3
4 6 1
5 6 3
6 7 4

source node = 0
 */