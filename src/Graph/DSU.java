package Graph;

import java.util.Scanner;

public class DSU {

    static int par[];
    static int size[];
    static int rank[];   // to find the number of linkage to that parent
    // here the T.C of find will be O(logn)
    // same goes for the union

    // here we can do one more optimization which is called path compresion
    // in which we set the child to its parent while returning from the base case of find operation

    // now using this optimization we have reduce the T.C from O(logn) to O(log*n)
    // here log*n means that minimum how many operation is needed to convert n to less than 1 w.r.t base 2;
    // for example log*2^32 is approx 5;

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

        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    static void printparent(){
        for(int i=0; i<par.length; i++){
            System.out.print(par[i]+" ");
        }
        System.out.println();
    }

    static void printsize(){
        for(int i=0; i<size.length; i++){
            System.out.print(size[i]+" ");
        }
        System.out.println();
    }

    static void printrank(){
        for(int i=0; i<rank.length; i++){
            System.out.print(rank[i]+" ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // number of Query
        par = new int[n+1];
        size = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++){
            par[i] = i;
            size[i] = 1;
        }

        while (m>0){
            String s = sc.next();
            if(s.equals("union")){
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a,b);
            }else{
                int x = sc.nextInt();
                System.out.println(find(x)+" "+size[x]);
            }
            m--;
        }
    }
}
