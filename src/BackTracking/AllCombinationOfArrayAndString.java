package BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class AllCombinationOfArrayAndString {

    static void allPermutationInString(String s, String currAns, ArrayList<String> arr){
        if(s.length()==0){
            arr.add(currAns);
            return;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            String a = s.substring(0,i);
            String b = s.substring(i+1);
            allPermutationInString(a+b,currAns+ch,arr);
        }
    }


    static void printAllPermutationInString(String s, String currAns){
        if(s.length()==0){
            System.out.println(currAns);
            return;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            String a = s.substring(0,i);
            String b = s.substring(i+1);
            printAllPermutationInString(a+b,currAns+ch);
        }
    }


    static void allPermutationOfArray(int arr[], ArrayList<Integer> currArr ,ArrayList<ArrayList<Integer>> ans, boolean[] isVisted){

        if(currArr.size()==arr.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                list.add(currArr.get(i));
            }
            ans.add(list);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(isVisted[i]==false){      // tab hi call lagega;
                isVisted[i]=true;         // SC = O(n);
                currArr.add(arr[i]);
                allPermutationOfArray(arr,currArr,ans,isVisted);
                isVisted[i]=false;
                currArr.remove(currArr.size()-1);
            }


        }
        return;

    }

    static void allPermutationOfArray2(int arr[], ArrayList<ArrayList<Integer>> ans, int idx){

        if (idx == arr.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                list.add(arr[i]);
            }
            ans.add(list);                                 // SC = O(1);
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            int a = arr[i];
            arr[i] = arr[idx];          // swapping
            arr[idx] = a;

            allPermutationOfArray2(arr,ans,idx+1);

            int b = arr[idx];
            arr[idx]=arr[i];      // BackTracking
            arr[i]=b;
        }

        return;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> curr = new ArrayList<>();

        printAllPermutationInString("123","");
    }
}
