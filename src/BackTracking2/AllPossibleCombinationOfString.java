package BackTracking2;

import java.util.ArrayList;
import java.util.HashSet;

public class AllPossibleCombinationOfString {
    static ArrayList<String> helper(String s){
        if(s.length()==1){
            ArrayList<String> a = new ArrayList<>();
            a.add(s);
            return a;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            ArrayList<String> arr = helper(s.substring(0,i)+s.substring(i+1,s.length()));
            for(int j=0; j<arr.size(); j++){
                ans.add(ch+arr.get(j));
            }
        }

        return ans;
    }

    static void helper2(String s, String curr){
        if(s.length()==0){
            System.out.print(curr+" ");
            return;
        }
        for(int i=0; i<s.length(); i++){
            helper2(s.substring(0,i)+s.substring(i+1),curr+s.charAt(i));
        }
    }

    // BackTracking

    static void helper3(StringBuilder s, int idx){  //  // As String is immutable means it is passed by value
        if(idx==s.length()-1) {
            System.out.println(s);
            return;
        }

        for(int i=idx; i<s.length(); i++){
            swap(s,i,idx);
            helper3(s,idx+1);
            swap(s,i,idx);
        }
    }

    /* Now if there are repeted character in the String then this code will not work.
       for that take the help of hashset and before printing the permutation just check that the
       the string is present or not in the hashset

       or do not call the irelavent call
    */


    static void helper4(StringBuilder s, int idx){  //  // As String is immutable means it is passed by value
        if(idx==s.length()-1) {
            System.out.println(s);
            return;
        }

        HashSet<Character> hp = new HashSet<>();
        for(int i=idx; i<s.length(); i++){
            if(hp.contains(s.charAt(i))) continue;
            hp.add(s.charAt(i));
            swap(s,i,idx);
            helper4(s,idx+1);
            swap(s,i,idx);
        }
    }

    static void swap(StringBuilder s, int i, int j){
        char ch = s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,ch);
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("aba");
        helper4(s,0);
    }
}
