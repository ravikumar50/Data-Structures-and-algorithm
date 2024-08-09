
import java.util.*;
public class hack {

    static int dp[][];
    static int find(String s, String t, int i, int j){
        if(i>=s.length()){
            if(j<t.length()) return 0;
            else return 1;
        }

        if(j>=t.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        char ch1 = s.charAt(i);
        char ch2 = t.charAt(j);

        if(ch1==ch2 || ch2=='?'){
            return dp[i][j] = find(s,t,i+1,j+1);
        }else{
            return dp[i][j] = 0;
        }
    }
    static void helper(){
        String s = sc.next();
        String t = sc.next();
        boolean flag = false;
        int j = 0;
        int m = t.length();
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<n; i++) {
            if (i<n && j<m && sb.charAt(i) == t.charAt(j)) {
                j++;
            } else if (i<n && j<m && sb.charAt(i) == '?') {
                sb.setCharAt(i, t.charAt(j));
                j++;
            }

            if (j==m) {
                flag = true;
                if (i<n && sb.charAt(i) == '?') {
                    sb.setCharAt(i, 'a');
                }
            }
        }

        if (flag) {
            System.out.println("YES");
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }



    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- > 0){
            helper();
        }


    }
}
