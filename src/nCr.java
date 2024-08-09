import java.util.Scanner;

public class nCr {

    static final int N = 200005;
    static final int MOD = 1000000007;
    static long[] fact = new long[N];

    // Function to calculate a^b % mod
    static long pw(long a, long b) {
        long r = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                r = (r * a) % MOD;
            }
            b /= 2;
            a = (a * a) % MOD;
        }
        return r;
    }

    // Function to calculate C(n, k) % mod
    static long Cnr(long n, long k) {
        if (n < k) return 0;
        return (fact[(int) n] * pw((fact[(int) (n - k)] * fact[(int) k]) % MOD, MOD - 2)) % MOD;
    }

    // Function to precompute factorials modulo mod
    static void precomputeFactorials() {
        fact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }
    public static void main(String[] args) {
        precomputeFactorials();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(Cnr(n,r));
    }
}
