import java.util.*;
public class Main {

    static int par[];
    static int size[];
    static int rank[];

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)  return; // Both a and b are in the same set
        if(rank[a]>= rank[b]){
            par[b] = a;
            rank[a]++;
            size[a]+=size[b];

        }else{
            par[a] = b;
            rank[b]++;
            size[b]+=size[a];
        }
    }
    public static ArrayList<Integer> maximumFriends(int n, int[][] arr) {
        // code here

        par = new int[n+10];
        size = new int[n+10];
        rank = new int[n+10];
        for(int i=0; i<n+10; i++) par[i] = i;
        for(int i=0; i<n+10; i++) size[i] = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 1;
        for(int i=0; i<n; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            if(find(a)!=find(b)){
                union(a,b);
            }
            max = Math.max(max,Math.max(size[par[a]],size[par[b]]));
            ans.add(max-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2},{1,3},{3,6},{3,5},{3,4}};
        int n = arr.length;
        System.out.println(maximumFriends(n,arr));
    }
}
