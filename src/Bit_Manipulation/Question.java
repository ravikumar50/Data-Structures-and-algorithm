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

    static int minimum_number_of_bit_flips_to_convert_one_number_to_another(int a, int b){

        // One solution can be that just take the xor of both the number and count the number of
        // occurance of 1 in the resultant number
        // this will give the answer

        int x = a^b;
        return number_of_set_bits(x);
    }

    static int singleNumber(int arr[]){  // leetcode 136
        int ans = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            ans = ans^arr[i];
        }
        return ans;
    }

    static int[] singleNumber3(int arr[]){  // leetcode 260
        int n = arr.length;
        int ans = 0;
        for(int i=0; i<n; i++) ans = ans^arr[i];

        int temp = ans;
        int k = 0;   // finding the last set bits of ans;
        while(true){
            if((temp&1)==1) break;
            k++;
            temp = temp>>1;  // dividing by 2
        }
        int a = 0;
        // taking the xor with those number which has kth bit as set bit
        for(int i=0; i<n; i++){
            if(((arr[i]>>k) & 1)==1) a = a^arr[i];
        }
        int b = ans^a; // finding the second number
        return new int[]{a,b};
    }


    static int lengthOfMaximumSubArrayWhoseAndIsMaximun(int arr[]){

        // See interesting facts 2
        int n = arr.length;
        int ans = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for(int j=0; j<n; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }

        int i=0,j=0;
        while(j<n){
            if(arr[j]==max){
                count = j-i+1;
            }else{
                i=j+1;
                count = 1;
            }
            j++;
            ans = Math.max(ans,count);
        }
        return ans;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,3,3,1,2,3,3};
        int ans = lengthOfMaximumSubArrayWhoseAndIsMaximun(arr);
        System.out.println(ans);
    }
}
