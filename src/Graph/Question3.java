package Graph;

public class Question3 {

    // leetcode - 2316

    static int par[];
    static int size[];

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;

        if(size[a]>=size[b]){
            par[b] = a;
            size[a]+=size[b];
        }else{
            par[a] = b;
            size[b]+=size[a];
        }
    }

    static long unreachablePair(int n, int[][] edges){
        par = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<edges.length; i++){
            union(edges[i][0],edges[i][1]);
        }

        long sum = 0;
        long ans = 0;


        for(int i=0; i<n; i++){
            if(par[i]==i){
                ans = ans + sum*size[i];
                sum = sum + size[i];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 7;
        int edges[][] = {{0,2},{0,5},{2,4},{1,6},{5,4}};

        System.out.println(unreachablePair(n,edges));
    }
}
