import java.util.Scanner;


public class Hcf {

    static void hcf(int a, int b) {

        int ans = 1;

        if (a <= b) {
            for (int i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    ans = i;
                }
            }
        } else {
            for (int i = 1; i < b; i++) {
                if (a % i == 0 && b % i == 0) {
                    ans = i;
                }
            }
        }

        System.out.println(ans);
    } // TC = O(min a,b)


    static int hcfbettertc(int a, int b) {

            while (b % a != 0) {
                int r = b % a;
                b = a;
                a = r;
            }
        return a;
    }

    // for lcm ,  lcm = (a*b)/hcf


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(hcfbettertc(a,b));


    }
}

