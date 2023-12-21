import java.util.Scanner;
import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Integer i = Integer.valueOf(5);
//        System.out.println(i);
//
//        Character ch = Character.valueOf('c');
//        System.out.println(ch);
//
//        String s = String.valueOf("Ravi");
//        System.out.println(s);
//
//        Boolean b = Boolean.valueOf("true");
//        System.out.println(b);
//
//        Float f = Float.valueOf(4.9f);
//        System.out.println(f);

        ArrayList<Integer> l1 = new ArrayList<>();
//        ArrayList<Boolean> l2 = new ArrayList<>();
//        ArrayList<Character> l3 = new ArrayList<>()

        l1.add(3);
        l1.add(4);
        l1.add(2);
        l1.add(7);

//        System.out.println(l1.get(3));

//         for(int i=0; i<l1.size(); i++){
//             System.out.print(l1.get(i)+" ");
//         }
//        System.out.println();

        System.out.println(l1);

//        ArrayList<Integer> l2 = new ArrayList<>();

        l1.add(1,10);   // adding new value
        System.out.println(l1);

        l1.set(1,15);    // replacing the value
        System.out.println(l1);

        l1.remove(1);  // removing element if index is known
        System.out.println(l1);

        l1.remove(Integer.valueOf(4));  // removing element if index is not known
        System.out.println(l1);

        System.out.println(l1.contains(Integer.valueOf(15))); // checks it is present or
        // not and returns boolean result




        ArrayList l = new ArrayList();
        l.add(3);
        l.add("Ravi");
        l.add(5.9);

        System.out.println(l);


//        for (int j = 0; 1 < 2; j++) {
//            int a = sc.nextInt();
//            if (a == -1)
//                break;
//            l2.add(a);
//        }
    }

    }

