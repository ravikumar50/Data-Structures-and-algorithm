import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> l1 = new ArrayList<>();

        for (int j = 0; 1 < 2; j++) {
            int a = sc.nextInt();
            if (a == 0)
                break;
            l1.add(a);
        }

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) > 0) {
                System.out.print(l1.get(i)+" ");
            }
        }
    }
}

