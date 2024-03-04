import BinaryTrees.Implementation;

import java.util.Stack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Hello {
    static String printLargest(int n, String[] arr) {
    // code here
    Arrays.sort(arr,(a,b)->((a+b).compareTo(b+a)));
    String ans = "";
    for(int i=0; i<n; i++){
        ans = arr[i]+ans;
    }
    return ans;
}
    public static void main(String[] args) {
        String arr[] = {"3", "30", "34", "5", "9"};
        int n = arr.length;
        System.out.println(printLargest(n,arr));
    }
}
