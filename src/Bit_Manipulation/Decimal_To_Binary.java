package Bit_Manipulation;

public class Decimal_To_Binary {
    static String helper(int n){
        String ans = "";

        while(n!=0){
            if(n%2==0){
                ans = "0"+ans;
            }else{
                ans = "1"+ans;
            }

            n = n >> 1;
        }
        return ans;
    }

    // left shift means multiplication by 2
    // right shift means division by 2

    /*
    a>>b = a/2^b
    a<<b = a*2^b
     */
    public static void main(String[] args) {
        int n = 8;
        String ans = helper(n);
        System.out.println(ans);
    }
}
