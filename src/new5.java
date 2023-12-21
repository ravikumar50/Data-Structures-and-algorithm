import java.util.Scanner;

public class new5 {

    static String reverse(String s){
        String x = "";
        int n = s.length()-1;


        while(n>=0){
            char ch = s.charAt(n);
            x+=ch+"";
            n--;
        }

        return x;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String");
        String s = sc.nextLine();

        String x = reverse(s);

        if(s.equals(x)){
            System.out.println("Given String is a Pallindrome");
        }else{
            System.out.println("Given String is not Pallindrome");
        }
    }
}
