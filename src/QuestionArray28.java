import java.util.Scanner;

class Prefix{
    public int[] Array(int[] arr){
            int x=arr.length;
            int[] pref = new int[x];
            pref[0]=arr[0];

            for(int i=1; i<x; i++){
                pref[i]=pref[i-1]+arr[i];
            }
        return pref;
    }
}

class Suffix{
    public int[] Array(int[] arr){
        int x=arr.length;
        int[] suff = new int[x];


        suff[x-1]=arr[x-1];
        for(int i=x-1; i>0; i--){
            suff[i-1]=suff[i]+arr[i-1];
        }
        return suff;
    }
}

public class QuestionArray28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int[] arr = obj.Array();

        Prefix obj2 = new Prefix();
        int [] ans = obj2.Array(arr);

        Suffix obj3 = new Suffix();
        int[] ans2 = obj3.Array(arr);

        Print obj4 = new Print();
        obj4.Array(ans);
        obj4.Array(ans2);

    }
}
