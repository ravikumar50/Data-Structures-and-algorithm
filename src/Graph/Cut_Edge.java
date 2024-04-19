package Graph;

import java.util.Scanner;
import java.util.ArrayList;

public class Cut_Edge{

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
        }else{
            par[a] = b;
            rank[b]++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int m = sc.nextInt();
        int edge[][] = new int[m][2];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            edge[i] = new int[]{a,b};
        }


        ArrayList<Integer> cutEdge = new ArrayList<>();

        for(int k=0; k<n; k++){
            par = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++) par[i] = i;

            for(int i=0; i<m; i++){
                int a = edge[i][0];
                int b = edge[i][1];
                if(a!=k && b!=k){
                    union(a,b);
                }
            }

            int x = 0;
            for(int i=0; i<n; i++){
                if(i==k) continue;

                if(par[i]==i) x++;
            }
            if(x>1) cutEdge.add(k);
        }
        System.out.println(cutEdge);
    }
}


/*
8
8
0 1
0 2
1 3
1 7
2 4
2 5
2 6
3 4
 */
