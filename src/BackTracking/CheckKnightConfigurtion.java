package BackTracking;

import java.util.Scanner;

public class CheckKnightConfigurtion {

    static int helper(int x, int sum){
        if(sum==0) return 1;
        if(sum<0) return 0;
        if(x>sum) return 0;

        int a = helper(x+2,sum-x);
        int b = helper(x+2,sum);
        return a+b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t>0){
            int n = sc.nextInt();
            int ans = helper(1,n);
            System.out.println(ans);
            t--;
        }
    }
}

/*

 */
