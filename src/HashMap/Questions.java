package HashMap;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Questions {

    static HashMap<Character, Integer> FrequencyInString(String s){
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();


        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
        }

        return mp;
    }

    static boolean anagramString(String s1, String s2){
        int n1=s1.length();
        int n2=s2.length();
        if(n2!=n1) return false;
        HashMap<Character,Integer> mp1 = FrequencyInString(s1);
        HashMap<Character,Integer> mp2 = FrequencyInString(s2);

        return mp1.equals(mp2);
    }

    static int minNumberRemovedToMakeAnagram(String s1, String s2){
        int n1 = s1.length();

        HashMap<Character, Integer> mp1 = new HashMap<>();

        for(int i=0; i<n1; i++){
            char ch = s1.charAt(i);

            if(mp1.containsKey(ch)){
                mp1.put(ch,mp1.get(ch)+1);
            }else{
                mp1.put(ch,1);
            }
        }

        int freq1 = -1;
        char key1 = '0';
        for(var a : mp1.entrySet()){
            if(a.getValue()>freq1){
                freq1=a.getValue();
                key1=a.getKey();
            }
        }

        int n2 = s2.length();

        HashMap<Character, Integer> mp2 = new HashMap<>();

        for(int i=0; i<n2; i++){
            char ch = s2.charAt(i);

            if(mp2.containsKey(ch)){
                mp2.put(ch,mp2.get(ch)+1);
            }else{
                mp2.put(ch,1);
            }
        }

        int freq2 = -1;
        char key2 = '0';
        for(var a : mp2.entrySet()){
            if(a.getValue()>freq2){
                freq2=a.getValue();
                key2=a.getKey();
            }
        }

        int ans=0;

        for(var a : mp1.entrySet()){
            if(mp2.containsKey(a.getKey())){
                ans+=Math.abs(a.getValue()-mp2.get(a.getKey()));
            }else{
                ans+=a.getValue();
            }
        }

        for(var a : mp2.entrySet()){
            if(!mp1.containsKey(a.getKey())){
                ans=ans+a.getValue();
            }
        }

        return ans;
    }

    static boolean isomorphicStrings(String s1, String s2){
        HashMap<Character, Character> mp = new HashMap<>();
        int n = s1.length();
        for(int i=0; i<n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(!mp.containsKey(ch1)){
                if(mp.containsValue(ch2)) return false;
                else mp.put(ch1,ch2);
            }else{
                if(ch2!=mp.get(ch1)) return false;
            }
        }
        return true;
    }


    static int maxFrequencyInArray(int arr[]){

        int n = arr.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            int a = arr[i];

            if(mp.containsKey(a)){
                mp.put(a,mp.get(a)+1);
            }else{
                mp.put(a,1);
            }
        }
        int key=-1;
        int freq=-1;

        for(var a : mp.entrySet()){
            if(a.getValue()>freq){
                key=a.getKey();
                freq=a.getValue();
            }
        }
        return key;
    }

    static int[] targetSumUsingHashMap(int arr[], int target){
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans[]={-1};
        for(int i=0; i<n; i++){
            if(mp.containsKey(target-arr[i])){
                ans = new int[]{i,mp.get(target-arr[i])};
                return ans;
            }else{
                mp.put(arr[i],i);
            }
        }
        return ans;
    }

    static int[] targetTripleSumUsingHashMap(int arr[], int target){
        int n = arr.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans[] = {-1};

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int patner=target-arr[i]-arr[j];
                if(mp.containsKey(patner)){
                    ans = new int[]{i,j,mp.get(patner)};
                    return ans;
                }else{
                    mp.put(arr[j],j);
                }
            }
            mp.put(arr[i],i);
        }
        return ans;
    }

    static int longestLengthSubArrayOfSumZero(int arr[]){
        int n = arr.length;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int prefixSum=0;
        int maxLength=-1;

        mp.put(0,-1);

        for(int i=0; i<n; i++){
            prefixSum+=arr[i];

            if(mp.containsKey(prefixSum)){
                maxLength = Math.max(maxLength,i-mp.get(prefixSum));
            }else{
                mp.put(prefixSum,i);
            }
        }
        return maxLength;
    }

    static int numberOfSubArrayWithSumEqualsToK(int arr[], int k){
        int n = arr.length;

        HashMap<Integer, Integer> mp = new HashMap<>();    // incomplete;
        mp.put(0,-1);

        int presum = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            presum+=arr[i];

            if(mp.containsKey(presum-k)){
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String s1 = "aabc";
        String s2 = "abcc";

        System.out.println(minNumberRemovedToMakeAnagram(s1,s2));
    }
}
