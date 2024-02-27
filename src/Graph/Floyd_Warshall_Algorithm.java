package Graph;

import java.util.*;

public class Floyd_Warshall_Algorithm
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
        int m = sc.nextInt();
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        System.out.println("Enter the Pairs along with their cost");

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            addEdge(a,b,c);
        }

        int d[][] = new int[n][n];
        int via[][] = new int[n][n];

        for(var a : d) Arrays.fill(a,Integer.MAX_VALUE);
        for(var a : via) Arrays.fill(a,-1);

        for(int i=0; i<n; i++){
            for(var a : graph[i]){
                d[i][a[0]] = a[1];
                via[i][a[0]] = i;
            }
            d[i][i] = 0;
        }


        for(int k=0; k<n; k++){
            int newD[][] = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(d[i][k]==Integer.MAX_VALUE || d[k][j]==Integer.MAX_VALUE){
                        newD[i][j] = d[i][j];
                    }else{
                        newD[i][j] = Math.min(d[i][j], (d[i][k] + d[k][j]));
                        if(d[i][j]>(d[i][k]+d[k][j])){
                            via[i][j] = k;
                        }
                    }
                }
            }
            d = newD;
        }

        System.out.println("Shortest distance of each pair is ");
        for(var a : d){
            for(var b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }

        System.out.println();


        System.out.println("Shortest distance of each pair via ");
        for(var a : via){
            for(var b : a){
                System.out.print(b+" ");
            }
            System.out.println();
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
1 4 7
2 1 4
3 2 -5
3 0 2
4 3 6

Shortest distance of each pair is
0 1 -3 2 -4
3 0 -4 1 -1
7 4 0 5 3
2 -1 -5 0 -2
8 5 1 6 0

Shortest distance of each pair via
-1 4 4 4 0
3 -1 3 1 3
3 2 -1 1 3
3 2 3 -1 0
3 3 3 4 -1

Process finished with exit code 0


 */