import java.util.Arrays;
import java.util.Comparator;

public class LargestBinaryNumber {




    static int helper(int x[]){
        int n = x.length;
        Integer arr[] = new Integer[n];
        for(int i=0; i<n; i++) arr[i] = x[i];

        Arrays.sort(arr,(a,b)->{
            String s1 = Integer.toBinaryString((int)a);
            String s2 = Integer.toBinaryString((int)b);

            return (s1+s2).compareTo(s2+s1);
        });


        StringBuilder ans = new StringBuilder();
        for(var a : arr){
            ans.append(a);
        }
        return Integer.valueOf(ans.toString(),2);
    }

    public static void main(String[] args) {
        int arr[] = {1,11,5};
        System.out.println(helper(arr));
    }
}
