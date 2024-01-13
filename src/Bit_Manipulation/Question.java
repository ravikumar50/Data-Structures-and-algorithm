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

    static int maximum_power_of_two_less_than_n(int n){

        // The answer will be the number which has the most significant bit same as the given
        // number and after that all the bits equal to 0
        // example n = 1001001 ans will be 1000000.

        // The idea for the ans will come from the above question
        // Just store the ans before n become 0

        int ans = n;
        while(n!=0){
            ans = n;
            n = n&(n-1);
        }
        return ans;
    }

    static int maximum_power_of_two_less_than_n_2(int n){
        n = n | n>>1;
        n = n | n>>2;
        n = n | n>>4;
        n = n | n>>8;
        n = n | n>>16;

        // this will make all the bits of n equals to 1;

        // n has become 2^x-1 and we want 2^(x-1);

        return (n+1)/2;

    }

    static int maximum_power_of_two_just_greater_than_n(int n){
        // just multiply the ans of the previous question by 2 , you will get your answer

        int ans = maximum_power_of_two_less_than_n(n)*2;
        return ans;
    }

    static int fliping_all_the_bits(int n){
        // just make all the bits of n equls to 1 and than take the xor of that number with n
        // this will flip all the bits of n

        int a = n;
        n = n | n>>1;
        n = n | n>>2;
        n = n | n>>4;
        n = n | n>>8;
        n = n | n>>16;

        return a^n;
    }
    public static void main(String[] args) {
        int n = 5;
        int ans = fliping_all_the_bits(n);
        System.out.println(ans);
    }
}
