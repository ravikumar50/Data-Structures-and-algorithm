import java.util.*;

public class DiamondPrinting
{

    static ArrayList<int[]> graph[];

    static void addEdge(int a, int b, int wt){
        graph[a].add(new int[]{b,wt});
        graph[b].add(new int[]{a,wt});
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
            int a = sc.next().charAt(0)-'a';
            int b = sc.next().charAt(0)-'a';
            int wt = sc.nextInt();
            addEdge(a,b,wt);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int ans[] = new int[n];
        int visited[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        Arrays.fill(visited,-1);
        pq.add(new int[]{0,0});
        ans[0] = 0;
        visited[0] = 1;

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

        for(int i=0; i<n; i++){
            System.out.print(ans[i]+" ");
        }
    }
}



/*

number of nodes = 8;
number of pairs = 14;

0 1 6
0 4 3
0 5 1
1 2 14
1 3 4
1 4 1
2 3 2
3 4 9
3 6 2
3 7 1
4 5 3
4 6 1
5 6 3
6 7 4

 */