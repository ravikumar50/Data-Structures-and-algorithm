package Bit_Manipulation;

public class Question {

    static int number_of_set_bits(int n){
        int ans = 0;

        while(n!=0){
            if(n%2==1) ans++;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 7;
        int ans = number_of_set_bits(n);
        System.out.println(ans);
    }
}
