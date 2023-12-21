package HashSet;

import java.util.HashSet;
import java.util.Scanner;

public class BasicOfHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> st = new HashSet<>();

        st.add("Ravi");
        st.add("Rishav");
        st.add("Ram");
        st.add("Shubham");
        st.add("Prince");
        st.add("Ravi");  // does not add duplicates elements

        st.remove("Prince");
        System.out.println(st.size());

        System.out.println(st.contains("ravi"));

        for(var a : st){
            System.out.print(a+" ");
        }



        System.out.println(st);
    }
}
