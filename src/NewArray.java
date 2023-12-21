import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class NewArray {

    static int[] smallestandlargestelements(int[] arr) {

        Arrays.sort(arr);

        int[] ans = {arr[0],arr[arr.length-1]};
        return ans;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String>  arr = new ArrayList<>();
        String str = "123.4%55423";
        for(int i=0; i<str.length(); i++){
            arr.add(String.valueOf(str.charAt(i)));
        }
        System.out.println(arr);

    }
}


