package HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Questions {

    static int longestLengthOfConsecutiveSequence(int arr[]){
        int n = arr.length;

        HashSet<Integer> st = new HashSet<>();

        for(int a : arr){
            st.add(a);
        }
        int ans = 0;
        for(int a : st){
            int k=1;
            if(!st.contains(a-1)){
                while(st.contains(a+1)){
                    a++;
                    k++;
                }
            }
            ans=Math.max(ans,k);
        }
        return ans;
    }

    static int maximumNumberOnTable(int arr[]){
        int n = arr.length;
        HashSet<Integer> st = new HashSet<>();
        int max = 0;

        for(int a : arr){

            if(!st.contains(a)){
                st.add(a);
                max=Math.max(max,st.size());
            }else{
                st.remove(a);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        int ans = maximumNumberOnTable(arr);
        System.out.println(ans);

    }
}
