import java.util.*;

public class new4 {

    static String helper(StringBuilder a, StringBuilder b){
        a.append("0".repeat(b.length()-1));
        int idx = b.length();
        int n = a.length();
        String curr = a.substring(0,b.length());
        while(true){
            char ch = curr.charAt(0);
            if(ch=='1'){
                String x = "";
                for(int i=1; i<curr.length(); i++){
                    if(curr.charAt(i)==b.charAt(i)) x+="0";
                    else x+="1";
                }
                if(idx>a.length()) break;
                if(idx<a.length()) x+=a.charAt(idx);
                idx++;
                curr = x;
            }
            else{
                String x = curr.substring(1);
                if(idx>a.length()) break;
                if(idx<a.length()) x+=a.charAt(idx);
                idx++;
                curr = x;
            }
        }
        return curr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Dividend ");
        StringBuilder a = new StringBuilder(sc.next());
        System.out.println("Enter the Divisor ");
        StringBuilder b = new StringBuilder(sc.next());
        String ans = helper(a,b);
        System.out.println("The remainder after dividing "+a+" by "+b+" is "+ans);
    }
}