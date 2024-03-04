package Graph;

import java.util.Scanner;

/*

G(i,s) = min(k E s) [ cost(ik)+G(k,s-k)]

 */

import java.util.*;

public class Travelling_Salesman_Problem {



    static int helper(int cost[][], int st, ArrayList<Integer> arr){
        if(arr.size()==0){
            return cost[st][0];
        }

        int c = Integer.MAX_VALUE;
        int idx = -1;

        for(int i=0; i<arr.size(); i++){
            int a = arr.get(i);
            arr.remove(Integer.valueOf(a));
            int x = cost[st][a]+helper(cost,a,arr);
            if(c>=x){
                c = x;
                idx = i;
            }
            arr.add(i,a);
        }

        return c;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost[][] = {{0,10,15,20},
                        {5,0,25,10},
                        {15,30,0,5},
                        {15,10,20,0}};
        int n = cost.length;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<n; i++){
            arr.add(i);
        }
        System.out.println(helper(cost,0,arr));
    }
}
