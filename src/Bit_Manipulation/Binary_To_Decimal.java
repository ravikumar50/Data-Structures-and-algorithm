package Bit_Manipulation;

public class Binary_To_Decimal {

    static int helper(String s){
        int ans = 0;
        int n = s.length();

        for(int i=n-1; i>=0; i--){
            int a = s.charAt(i)-48;
            ans = ans + a*(1<<(n-1-i));    // 1 << x = 2^x;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "101";
        int ans = helper(s);
        System.out.println(ans);
    }
}
