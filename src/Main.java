

import java.util.*;

public class Main
{

    static ArrayList<double[]> graph[];

    static void addEdge(int a, int b, double wt){
        graph[a].add(new double[]{b,wt});
    }


    static double[] helper(List<List<String>> eq, double val[], List<List<String>> q){
        int n = 26;
        int m = eq.size();
        graph = new ArrayList[26];
        for(int i=0; i<26; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            int a = eq.get(i).get(0).charAt(0)-'A';
            int b = eq.get(i).get(1).charAt(0)-'A';
            addEdge(a,b,val[i]);
        }

        double d[][] = new double[n][n];


        for(var a : d) Arrays.fill(a,Integer.MAX_VALUE);


        for(int i=0; i<n; i++){
            for(var a : graph[i]){
                d[i][(int)a[0]] = a[1];
            }
            d[i][i] = 1;
        }


        for(int k=0; k<n; k++){
            double newD[][] = new double[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(d[i][k]==Integer.MAX_VALUE || d[k][j]==Integer.MAX_VALUE){
                        newD[i][j] = d[i][j];
                    }else{
                        newD[i][j] = Math.min(d[i][j], (d[i][k] * d[k][j]));
                    }
                }
            }
            d = newD;
        }



        int s = q.size();
        double ans[] = new double[s];
        for(int i=0; i<s; i++){
            int a = q.get(i).get(0).charAt(0)-'A';
            int b = q.get(i).get(1).charAt(0)-'A';
            double x = d[a][b];
            if(x==Integer.MAX_VALUE){
                if(d[b][a]==Integer.MAX_VALUE){
                    ans[i] = -1;
                }else{
                    ans[i] = 1/d[b][a];
                }
            }else{
                ans[i] = x;
            }
        }
        return ans;

    }


    static int helper(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int s = sc.nextInt();
        int p[] = new int[s];
        for(int i=0; i<s; i++){
            p[i] = sc.nextInt();
        }

        if(s>n) return 0;
        int ans = 0;
        for(int i=0; i<n-s; i++){
            boolean flag = true;
            for(int j=1; j<=s; j++){
                if(p[j-1]==0){
                    if(arr[i+j]!=arr[i+j-1]){
                        flag = false;
                    }
                }else if(p[j-1]==1){
                    if(arr[i+j]<=arr[i+j-1]){
                        flag = false;
                    }
                }else if(p[j-1]==-1){
                    if(arr[i+j]>=arr[i+j-1]){
                        flag = false;
                    }
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
//        List<List<String>> x = new ArrayList<>();
//        List<String> x1 = new ArrayList<>(List.of("A","B"));
//        List<String> x2 = new ArrayList<>(List.of("C","D"));
//        List<String> x3 = new ArrayList<>(List.of("E","F"));
//        List<String> x3 = new ArrayList<>(List.of("B","G"));
//
//        x.add(x1);
//        x.add(x2);
//        x.add(x3);
//
//        double val[] = {4.0,5.0,6.0};
//
//        List<List<String>> q = new ArrayList<>();
//        List<String> q1 = new ArrayList<>(List.of("A","D"));
//        List<String> q2 = new ArrayList<>(List.of("D","A"));
//        List<String> q3 = new ArrayList<>(List.of("A","C"));
//        List<String> q4 = new ArrayList<>(List.of("B","D"));
//        List<String> q5 = new ArrayList<>(List.of("D","C"));
//        List<String> q6 = new ArrayList<>(List.of("X","C"));
//
//        q.add(q1);
//        q.add(q2);
//        q.add(q3);
//        q.add(q4);
//        q.add(q5);
//        q.add(q6);
//
//
//
//        double ans[] = helper(x,val,q);
//        for(var a : ans){
//            System.out.println(a);
//        }

        int arr[] = {0,0};
        int p[] = {0};
        System.out.println(helper());

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