import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class Arraylist1 {
    static void ReverseArrarlist(ArrayList<Integer> l1) {

        int i = 0;
        int j = l1.size() - 1;
        while (i < j) {
            int a =l1.get(i);
            l1.set(i,l1.get(j));
            l1.set(j, a);
            i++;
            j--;

        }
        System.out.println("Reversed Array List : "+l1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> l1 = new ArrayList<>();

        for (int j = 0; 1 < 2; j++) {
            int a = sc.nextInt();
            if (a == -1)
                break;
            l1.add(a);
        }

        System.out.println("Original Array list : "+l1);

        Collections.reverse(l1);  // reverse the Array list
        System.out.println(l1);
        ReverseArrarlist(l1);     //reverse once again


        }
}

