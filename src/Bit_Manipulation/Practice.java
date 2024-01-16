package Bit_Manipulation;

import java.util.*;

public class Practice {

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
        System.out.println("Enter the Pairs along with their weight");
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
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
                if (visited[x[0]] != 1 && ans[x[0]] > x[1]) {
                    ans[x[0]] = x[1];
                    pq.add(new int[]{x[0], x[1]});
                }
            }
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=ans[i];
        }
        System.out.println(sum);
    }
}

/*
0 1 4
1 2 8
2 3 7
3 4 9
4 5 10
5 6 2
6 7 1
7 0 8
1 7 11
7 8 7
8 2 2
2 5 4
3 5 14
8 6 6

 */
