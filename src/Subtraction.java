import java.util.*;

public class Subtraction {

    static String helper(String s1, String s2){
        int i = s1.length()-1;
        int j = s2.length()-1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;

        while(i>=0 || j>=0){
            int a = (i<0) ? 0 : s1.charAt(i)-'0';
            int b = (j<0) ? 0 : s2.charAt(j)-'0';

            int sum = a-b+carry;
            if(sum<0){
                sum+=10;
                carry = -1;
            }else{
                carry = 0;
            }
            i--;
            j--;
            ans.insert(0,sum);
        }
        if(carry<0){
            return helper(s2,s1);
        }
        int idx = 0;
        while(ans.charAt(idx)=='0') idx++;
        return ans.substring(idx).toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(helper(s1,s2));
    }
}
