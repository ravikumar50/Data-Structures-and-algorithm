import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Arraylist2 {

    static void SortArraylist(ArrayList<Integer> l1){

        int x;
        for(int i=0; i<l1.size(); i++){
            for(int j=0; j<l1.size(); j++){
                if(l1.get(i)>l1.get(j)){
                    x=l1.get(i);
                    l1.set(i,l1.get(j));
                    l1.set(j,x);
                }
            }
        }
        System.out.println("Sorted Array List "+l1);
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

        ArrayList<String> l2 = new ArrayList<>();
        l2.add("Welcome");
        l2.add("To");
        l2.add("My");
        l2.add("Home");

        Collections.sort(l2);
        System.out.println(l2);

        System.out.println("Original Array List "+l1);
        Collections.sort(l1);   // inbuild method
        System.out.println(l1);
        SortArraylist(l1);
    }
}
