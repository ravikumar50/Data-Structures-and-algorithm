import java.lang.reflect.Array;
import java.util.*;

class Main {

    static ArrayList<Integer> arr[];
    static int visited[];

    static int helper(int src){
        if(visited[src]==1) return 0;
        visited[src] = 1;
        return 1+helper(arr[src].get(0));
    }

    public static ArrayList<ArrayList<Integer>> longestCycle(int[] edges) {
        int n = edges.length;
        arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<>();

        int indegree[] = new int[n];
        for(int i=0; i<n; i++){
            if(edges[i]!=-1){
                arr[i].add(edges[i]-1);
                indegree[edges[i]-1]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        visited = new int[n];

        for(int i=0; i<n; i++){
            if(indegree[i]==0) q.add(i);
        }

        while(q.size()!=0){
            int a = q.remove();
            visited[a] = 1;
            for(var x : arr[a]){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }

        int ans = -1;
        ArrayList<Integer> k = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                int x = helper(i);
                if(ans<x){
                    k.clear();
                    k.add(i);
                    ans = x;
                }
            }
        }


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(var src : k){
            HashSet<Integer> hp = new HashSet<>();
            ArrayList<Integer> x = new ArrayList<>();
            while(!hp.contains(src)){
                x.add(src+1);
                hp.add(src);
                src = arr[src].get(0);
            }
            if(x.size()!=0) res.add(x);
        }
        return res;
    }

    static int find(int num, int haystack){
        String s = String.valueOf(haystack);
        char ch = String.valueOf(num).charAt(0);
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==ch) ans++;
        }
        return ans;
    }

    static int[] helper(int fatherPos, int martinPos, int velFather, int steps)

    {

        int[] ans = new int[2];

        int[] temp = new int[steps + 1];

        for (int i = 0; i <= steps; i++)

            temp[i] = fatherPos + velFather * i - martinPos;

        for (int i = 0; i <= steps; i++)

        {

            if (temp[i] <= 0)

                continue;

            int v2 = temp[i];

            int count = 0;

            for (int j = i; j <= steps; j++)

            {

                if (temp[j] % v2 == 0)

                    count++;

            }

            if (ans[0] <= count)

            {

                ans[0] = count;

                ans[1] = v2;

            }

        }

        return ans;

    }


    static ArrayList<Integer> removeDuplicates(int arr[]){
        HashSet<Integer> hp = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(!hp.contains(arr[i])) ans.add(arr[i]);
            hp.add(arr[i]);

        }
        return ans;
    }


    public static void main(String[] args) {
        int arr[] = {1,1,3,2,1,4,5,4};
        System.out.println(removeDuplicates(arr));
    }
}