package Bit_Manipulation;

public class Decimal_To_Binary {
    static int helper(int n){
        int ans = 0;
        int tens = 1;

        while(n!=0){
            ans = ans + (n%2)*tens;
            n = n/2;
            tens = tens*10;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 7;
        int ans = helper(n);
        System.out.println(ans);
    }
}
