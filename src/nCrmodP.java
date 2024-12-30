public class nCrmodP{

    static long p = (long)(1e9)+7;
    static long fact[];
    static long invFact[];
    static long modExp(long base, long exp) {
        long result = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % p;
            }
            base = (base * base) % p;
            exp >>= 1;
        }
        return result;
    }


    static long nCr(int n, int r){
        preCompute(n);
        if(r<0 || r>n) return 0;

        long a = fact[n];
        long b = invFact[r];
        long c = invFact[n-r];
        return ((a*b)%p*c)%p;
    }

    static void preCompute(int n){
        fact = new long[n+1];
        invFact = new long[n+1];

        fact[0] = 1;
        for(int i=1; i<=n; i++){
            fact[i] = ((fact[i-1]%p)*(i))%p;
        }

        invFact[n] = modExp(fact[n],p-2)%p;
        for(int i=n-1; i>=0; i--){
            invFact[i] = ((invFact[i+1]%p)*(i+1))%p;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int r = 2;

        System.out.println(nCr(n,r));
    }
}