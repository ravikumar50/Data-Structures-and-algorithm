package Graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bellman_Ford_Algorithm {


    static ArrayList<int[]> graph[];

    static void addEdge(int src, int dest, int wt) {
        graph[src].add(new int[]{dest, wt});
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numner of Nodes");
        int n = sc.nextInt();
        System.out.println("Enter the number of Edges");
        int m = sc.nextInt();
        int edge[][] = new int[m][3];

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter the edges along with their weight");

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int wt = sc.nextInt();
            edge[i] = new int[]{a,b,wt};
            addEdge(a,b,wt);
        }

        int ans[] = new int[n];
        Arrays.fill(ans,100000);
        ans[0] = 0;

        for(int i=1; i<n; i++){

            for(int j=0; j<m; j++){
                int a[] = edge[j];
                if(ans[a[0]]+a[2]<ans[a[1]]){
                    ans[a[1]] = ans[a[0]]+a[2];
                }
            }
        }

        boolean flag = false;

        // for checking if there exists a negative cycle or not

        int newAns[] = Arrays.copyOf(ans,ans.length);

        for(int j=0; j<m; j++){
            int a[] = edge[j];
            if(ans[a[0]]+a[2]<newAns[a[1]]){
                newAns[a[1]] = ans[a[0]]+a[2];
            }
        }
        for(int i=0; i<n; i++){
            if(newAns[i]<ans[i]){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("There exists a negative cycle in the graph");
            for(int i=0; i<n; i++){
                System.out.print(newAns[i]+" ");
            }
        }else {
            System.out.println("Minimum distance of each node from source node is : ");
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }

}

/*

number of nodes = 7
number of edges = 10

Edges along with their weight

0 1 6
0 2 5
0 3 5
1 4 -1
2 1 -2
2 4 1
3 2 -2
3 5 -1
4 6 3
5 6 3

minimum distance from source
0 1 3 5 0 4 3

 */
