package Bit_Manipulation;

public class Question {

    static int number_of_set_bits(int n){
        int ans = 0;

        while(n!=0){
            n = n & (n-1);     // see interesting facts 1
            ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 10;
        int ans = number_of_set_bits(n);
        System.out.println(ans);
    }
}
