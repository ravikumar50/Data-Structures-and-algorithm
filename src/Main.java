import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long l = sc.nextLong();

            HashSet<Long> hp = new HashSet<>();

            for(long x=1; x<=l; x=x*a){
                for(long y=1; y<=l; y=y*b){
                    if(l%(x*y)==0) hp.add(l/(x*y));
                }
            }
            System.out.println(hp.size());
            t--;
        }
    }
}