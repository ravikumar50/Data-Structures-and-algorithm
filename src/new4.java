import Graph.Prims_Algorithm;

import java.util.*;



public class new4 {


    static ArrayList<int[]> graph[];

    static void addEdge(int a, int b, int wt){
        graph[a].add(new int[]{b,wt});
        graph[b].add(new int[]{a,wt});
    }
    static int findCity(int n, int m, int[][] edges,int k){
        //code here

        graph = new ArrayList[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            addEdge(a,b,c);
        }



        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = i;
            int v = n;
            int visited[] = new int[v];
            int ans[] = new int[v];
            int via[] = new int[v];  // optional
            Arrays.fill(ans,Integer.MAX_VALUE);
            Arrays.fill(visited,-1);
            ans[start] = 0;


            PriorityQueue<int[]> pq = new PriorityQueue<>(new Prims_Algorithm.weightComparator());

            pq.add(new int[]{start,0});
            visited[start] = 1;

            while(pq.size()!=0){     // T.C (V+E)*LogV
                int a[] = pq.remove();
                visited[a[0]] = 1;

                for(var x : graph[a[0]]){
                    if(visited[x[0]]!=1 && ans[x[0]]>ans[a[0]]+x[1]){
                        ans[x[0]] = ans[a[0]]+x[1];

                        pq.add(new int[]{x[0],ans[x[0]]});
                    }
                }
            }
            arr.add(ans);
        }


        int min = Integer.MAX_VALUE;
        int res = -1;

        for(int i=0; i<arr.size(); i++){
            int a[] = arr.get(i);
            int count = 0;
            for(int j=0; j<n; j++){
                if(a[j]<=k) count++;
            }
            System.out.println();
            if(min>count){
                min = count;
                res = i;
            }else if(min==count){
                res = Math.max(res,i);
            }
        }


        return res;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 2;
        int n = 5;
        int m = 6;
        int edges[][] = new int[m][3];
        for(int i=0; i<6; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }



        System.out.println(findCity(n,m,edges,k));
    }
}
