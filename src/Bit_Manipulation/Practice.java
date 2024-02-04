package Bit_Manipulation;

import java.util.*;


public class Practice {

    static ArrayList<int[]> graph[];

    static void addEdge(int a, int b, int wt){
        graph[a].add(new int[]{b,wt});
        graph[b].add(new int[]{a,wt});
    }


    public static void main(String[] args) {

        int arr[] = {5,4,1,2,2};
        int n = arr.length;

        HashMap<Integer,Integer> hp = new HashMap<>();

        for(int i=0; i<n; i++){
            hp.put(arr[i],hp.getOrDefault(arr[i],0)+1);
        }
        int ans = Integer.MIN_VALUE;
        System.out.println(hp);

        for(var a : hp.keySet()){
            if(a==1) ans = Math.max(ans,hp.get(a));
            else{
                int count = 0;
                int x = a;

            }
        }

    }
}

/*

1 2 9
1 3 5
2 1 3
2 4 18
3 4 12
4 2 2
4 8 8
5 4 9
5 8 3
5 7 5
5 6 2
6 7 1
7 5 4
7 8 6
8 5 3

 */
