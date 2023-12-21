package Graph;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DSUQuestion {



    // codeforces - disjoint set union 2
    static int find(int a, int par[]){
        if(par[a]==a) return a;
        else return par[a] = find(par[a],par);
    }

    static void union(int a, int b,int par[], int rank[], int size[], int max[], int min[]){
        a = find(a,par);
        b = find(b,par);
        if(a==b) return;

        if(rank[a]>rank[b]){
            size[a]+=size[b];
            par[b]=a;
            max[a] = Math.max(max[a],max[b]);
            min[a] = Math.min(min[a],min[b]);
            rank[a]++;
        }else{
            size[b]+=size[a];
            par[a]=b;
            max[b] = Math.max(max[a],max[b]);
            min[b] = Math.min(min[a],min[b]);
            rank[b]++;
        }
    }


    // leetcode 547 (number of provinces)

    // this question can be solved using finding the number of connected components
    // i.e do BFS/DFS on each node and the number of times you are able to do the
    // BFS/DFS will be your answer and I have done this question in that way

    // But this question can be also solved using DSU i.e just put those nodes in
    // same group which are connected to each others and the total number of leaders
    // will be your ans;

    // Given below is the code in which I have solved this question using DSU


    static int find2(int a, int par[]){
        if(par[a]==a) return a;
        else return par[a] = find2(par[a],par);
    }

    static void union2(int a, int b, int par[], int rank[]){
        a = find(a,par);
        b = find(b,par);
        if(a==b) return;

        if(rank[a]>rank[b]){
            par[b] = a;
            rank[a]++;
        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    // Alien Dictionary leetcode 269 // gfg
    // topological sorting

    static void addEdge(char a, char b, ArrayList<Character> graph[]){
        graph[a-97].add(b);
    }

    static String alienDictionary(String arr[]){
        ArrayList<Character> graph[] = new ArrayList[26];

        for(int i=0; i<26; i++){
            graph[i] = new ArrayList<>();
        }

        HashSet<Character> hp = new HashSet<>();
        ArrayList<char[]> dependend = new ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            String s1 = arr[i];
            String s2 = arr[i+1];

            int a=0,b=0;
            while(a<s1.length() && b<s2.length()){
                if(s1.charAt(a)!=s2.charAt(b)){
                    hp.add(s1.charAt(a));
                    hp.add(s2.charAt(b));
                    dependend.add(new char[]{s1.charAt(a),s2.charAt(b)});
                    break;
                }
                a++;
                b++;
            }
        }

        int indegree[] = new int[26];

        for(int i=0; i<dependend.size(); i++){
            indegree[dependend.get(i)[1]-97]++;
            addEdge(dependend.get(i)[0],dependend.get(i)[1],graph);
        }

        Queue<Integer> q = new LinkedList<>();


        for(int i=0; i<indegree.length; i++){
            char ch = (char)(i+97);
            if(indegree[i]==0 && hp.contains(ch)) q.add(i);
        }

        StringBuilder ans = new StringBuilder("");
        while(q.size()!=0){
            int a = q.remove();
            ans.append((char)(a+97));
            for(var x : graph[a]){
                indegree[x-97]--;
                if(indegree[x-97]==0) q.add(x-97);
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {

        String arr[] =  {"baa","abcd","abca","cab","cad"};

        System.out.println(alienDictionary(arr));

    }
}