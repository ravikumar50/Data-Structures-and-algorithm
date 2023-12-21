import RMI.ArrayRemote;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Recursion {

    static void Print(int n){
        if(n==0){
            return;
        }
        System.out.print("Ravi ");
        Print(n-1);
    }

    static void Printincresing(int n){
        if(n==1){
            System.out.print("1 ");
            return;
        }
        Printincresing(n-1);
        System.out.print(n+" ");
    }

    static void Printdecresing(int n){
        if(n==0){
            return;
        }

        System.out.print(n+" ");
        Printdecresing(n-1);
    }

    static int Sum(int n){

        if(n==1) {
            return 1;
        }

        return n+Sum(n-1);
    }

    static int Factorial(int n){
        if(n==0) return 1;
        return n*Factorial(n-1);
    }

    static int Fabonacci(int n){
        if(n==0||n==1) return n;
        return Fabonacci(n-1)+Fabonacci(n-2);
    }

    static int Sumofdigit(int n){

        if(n<10) return n;
        return n%10+Sumofdigit(n/10);
    }

    static int Numberofdigit(int n){

        if(n<10) return 1;
        return 1+Numberofdigit(n/10);
    }

    static int Powerofnumber(int p, int q){

          if(q==0) return 1;
          return p*Powerofnumber(p,q-1);
    }    // TC = O(q)

    static int PowerofnumberbetterTC(int p, int q){
        if(q==0) return 1;
        int smallpow=PowerofnumberbetterTC(p,q/2);

        if(q%2==0){
            return smallpow*smallpow;
        }
        else{
            return p*smallpow*smallpow;
        }
    }   // TC = O(log(q))

    static float Powerofnumbernegative(float p, int q){
        if(q==0) return 1;
        return 1/p*(Powerofnumbernegative(p,q+1));
    }

    static void Printkmultiples(int n, int k){

        if(k==0) return;
        Printkmultiples(n,k-1);
        System.out.println(n*k);
    }

    static int Sumalternatewithnegative(int n){
        if(n==1) return 1;

        if(n%2==0){
            return Sumalternatewithnegative(n-1)-n;
        }else{
            return Sumalternatewithnegative(n-1)+n;
        }

    }

    static void PatternPrinting(int n) {
        if (n <= 0) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        PatternPrinting(n - 5);
    }

    static void PatternPrinting2(int n) {
        if(n<=5){
            System.out.print(n+" ");
            return;
        }
        PatternPrinting2(n-5);
        System.out.println(n);
    }

    static int Hcf(int x, int y){
        if(y==0) return x;

        return Hcf(y,x%y);      // Euclid's Algorithm  Hcf(x,y)=Hcf(y,x%y) and Hcf(x,0)=x;
    }

    static int Sumofmthsummation(int n, int m){

        if(m==1) return (n*(n+1))/2;

        return Sumofmthsummation(Sumofmthsummation(n,m-1),1);
    }

    static int Armstrong(int a){
        if(a<10) return a*a*a;

        int x=a%10;
        return x*x*x + Armstrong(a/10);
    }

    static int DecimaltoBinary(int n, int x){
        if(n==0) return 0;

        return n%2*x + DecimaltoBinary(n/2, 10*x);
    }

    static int BinarytoDecimal(int n, int x){

        if(n==0) return 0;
        return n%10*Powerofnumber(2,x) + BinarytoDecimal(n/10,x+1);
    }

    static void Arrayprint(int[] arr, int x){

        if(x==0) return;
        Arrayprint(arr,x-1);
        System.out.print(arr[x-1]+" ");

    }

    static int Product(int a, int b){
        if(b==1) return a;

        return a+Product(a,b-1);
    }

    static int Arraymax(int[] arr, int x){

        if(x==arr.length-1) return arr[x];

        return Math.max(arr[x],Arraymax(arr,x+1));
        }

    static int Arraysum(int[] arr, int x){

        if(x==arr.length) return 0;
        return arr[x]+Arraysum(arr,x+1);
    }


    static int  findingaelement(int[] arr, int n, int x){

        if(n==arr.length) return -1;

        if(x==arr[n]) return  n;
        else return findingaelement(arr,n+1,x);
    }

    static void  findingaelementandprintindices(int[] arr, int n, int x) {
        if(n==arr.length) return;

        if(arr[n]==x) System.out.println(n);
        findingaelementandprintindices(arr,n+1,x);
    }

  /*  static int findlastindice(int[] arr, int n, int x){            not solved.
        if(n==arr.length) return -1;

        if(arr[n]==x){
            int ans = n;
            return ans;
        }
        findlastindice(arr, n+1,x);

        return ans;

    }    */

    static void isSorted(int[] arr, int n){
        if(n==arr.length-1){
            System.out.println("Sorted");
            return;
        }

        if(arr[n]<arr[n+1]){
            isSorted(arr,n+1);
        }
        else System.out.println("Not Sorted");
    }

    static ArrayList<Integer> findidices(int[] arr, int n, int x){
        if(n==arr.length) return new ArrayList<Integer>();

        ArrayList<Integer> ans = new ArrayList<>();

        if(arr[n]==x) ans.add(n);
        ArrayList<Integer> smallans = findidices(arr,n+1,x);
        ans.addAll(smallans);

        return ans;
    }

    static void trianglesumPatternofArray(int [] arr){

        if(arr.length<1) return;

        int[] arr2 = new int[arr.length-1];
        for(int i=0; i<arr2.length; i++){
            arr2[i] = arr[i]+arr[i+1];
        }


        trianglesumPatternofArray(arr2);
        System.out.println(Arrays.toString(arr));  // for printing an Array.
        }

/*        static void printAllCombinationOfArrayHavingRElements(int[] arr, int n, int r){
        if(n==arr.length-1) return;
                                                            // not solved.
        int[] arr2 = new int[r];
        arr2[0]=arr[n];

        for(int i=1; i<=arr.length-n-1; i++){
            arr2[1] = arr[i];
            System.out.println(Arrays.toString(arr2));
        }
        printAllCombinationOfArrayHavingRElements(arr,n+1,r);
        }

        static void abc(int[] arr, int r){
        if(arr.length==r-1) return;

        int[] arr2 = new int[r];

            arr2[0]=arr[0];
            for(int j=1; j<=arr.length-r+1; j++){
                arr2[1]=arr[j];
                for(int k=j+1;k<arr.length; k++){
                    arr2[2]=arr[k];
                    System.out.println(Arrays.toString(arr2));
                }
            }
        int[] arr3 = new int[arr.length-1];
        arr2=Arrays.copyOfRange(arr,1,arr.length);
        abc(arr3,r);

        } */

    static String removingAElementFromString(String s, int n){

        if(n==s.length())  return "";

        String ans = removingAElementFromString(s,n+1);
        if(s.charAt(n)!='a') return s.charAt(n)+ans;

        return ans;

    }

    static String sameAsAboveWithoutPassingIndex(String s){
        if(s=="") return "";

        String ans = sameAsAboveWithoutPassingIndex(s.substring(1));
        if(s.charAt(0)!='a') return s.charAt(0)+ans;

        return ans;
    }

    static String reversingAnString(String s){
        if(s=="") return "";

        String ans = reversingAnString(s.substring(1));
        return ans+s.charAt(0);
    }

    static boolean palindomeString(String s, int i, int j){
        if(i==j) return true;

        return (s.charAt(i)==s.charAt(j)) && palindomeString(s,i+1,j-1);
    }

    static String mergingTwoStringinAlternateOrder(String s1, String s2){
        if(s1=="" || s2=="") return "";
        if(s1=="") return s2;
        if(s2=="") return s1;

       String ans = mergingTwoStringinAlternateOrder(s1.substring(1),s2.substring(1));
       return s1.charAt(0)+s2.charAt(0)+ans;
    }

    static String returningStringAfterCapitalCase(String s){
        if(s=="") return "";

        int x = s.charAt(0);
        if(x>64 && x<91) return s;
        else return returningStringAfterCapitalCase(s.substring(1));
    }
    static int numberOfVowels(String s){
        if(s=="") return 0;

        int ans = numberOfVowels(s.substring(1));
        int x = s.charAt(0);
        if(x==97 || x==101 ||x==105 || x==111 ||x==117) return 1+ans;
        else return ans;
    }

    static ArrayList<String> returningSubsequencesOfStringInAnArrayList(String s){
           ArrayList<String> ans = new ArrayList<>();
           if(s==""){
               ans.add("");
               return ans;
           }
           ArrayList<String> smallAns = returningSubsequencesOfStringInAnArrayList(s.substring(1));

           for(int i=0; i<smallAns.size(); i++){
               ans.add(smallAns.get(i));
               ans.add(s.charAt(0)+smallAns.get(i));
           }

           return ans;
    }

    static void printingSubsequencesOfString(String s, String currentAns){ //currentans = "";
        if(s=="") {
            System.out.println(currentAns);
            return;
        }

        // curr char --> chooses to be a part;     s.charAt(0);
          printingSubsequencesOfString(s.substring(1),currentAns+s.charAt(0));

        // curr char --> chooses to not be a part;
          printingSubsequencesOfString(s.substring(1),currentAns);
    }

    static void printingSumOfAllSubsequencesofArray(int arr[], int n, int cuurentSum){
        if(n==arr.length){
            System.out.println(cuurentSum);
            return;
        }
        printingSumOfAllSubsequencesofArray(arr,n+1,cuurentSum+arr[n]);  // add 1st digit
        printingSumOfAllSubsequencesofArray(arr,n+1,cuurentSum);
    }

    static void NDigitNumberInIncreasingOrder(String currAns, int n, int k){

        if(n==0){
            System.out.println(currAns+" ");
            return;
        }


        for(int i=k; i<=9; i++){
            NDigitNumberInIncreasingOrder(currAns+i,n-1, i+1);
        }
    }

    static int frogJump(int[] arr, int n, int idx){

        if(idx==n-1) return 0;
        if(idx==n-2) return Math.abs(arr[idx]-arr[idx+1]);

        int option1 = frogJump(arr,n,idx+1)+Math.abs(arr[idx]-arr[idx+1]);
        int option2 = frogJump(arr,n, idx+2)+Math.abs(arr[idx]-arr[idx+2]);

        return Math.min(option1,option1);
    }


    static void telephoneProblem(String s, String currentAns,String[] keypad){
        if(s==""){
            System.out.print(currentAns+" ");
            return;
        }
         int x = s.charAt(0)-'0';
         String currentChoice=keypad[x];

         for(int i=0; i<currentChoice.length(); i++){
             telephoneProblem(s.substring(1),currentAns+currentChoice.charAt(i),keypad);
         }

            }

    static void tower(int n, char s, char h, char d){
        if(n==0) return;
        tower(n-1,s,d,h);
        System.out.println(s+" "+d+" ");
        tower(n-1,h,s,d);
    }

    static double sin(double x){
        if(-0.005<x && x>0.005) return x+(x*x*x)/6;
        return 2*sin(x/2)*cos(x/2);
    }

    static double cos(double x){
        if(-0.005<x && x>0.005) return x+(x*x)/2;
        return 1+2*(sin(x/2)*sin(x/2));
    }

    static int mazePath(int m, int n){
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;

        return mazePath(m-1,n)+mazePath(m,n-1);
    }

    static void printMazePath(int m, int n, String s){
        if(m==1 && n==1){
            System.out.println(s);
            return;
        }
        if(m==0 || n==0) return;

        printMazePath(m-1,n,s+"R");
        printMazePath(m,n-1,s+"D");
    }

    static int maze(int a, int b, int c, int d){
        if(a==c && b==d) return 1;        // 1 based Indexing
        if(a>c || b>d) return 0;

        return maze(a+1,b,c,d) + maze(a,b+1,c,d);
    }

    static int mazeIn4Direction(int a , int b, int c, int d, boolean isVisited[][]){

        int ans=0;
        if(a<0 || b<0 || a>c || b>d) return 0;
        if(isVisited[a][b]==true) return 0;
        if(a==c && b==d) return 1;       // 0 based Indexing

        isVisited[a][b]=true;
        ans+=mazeIn4Direction(a+1,b,c,d,isVisited);
        ans+=mazeIn4Direction(a-1,b,c,d,isVisited);
        ans+=mazeIn4Direction(a,b+1,c,d,isVisited);
        ans+=mazeIn4Direction(a,b-1,c,d,isVisited);

        isVisited[a][b]=false;    // backTracking;
        return ans;

    }

    static void printMazePathIn4Direction(int a, int b, int c, int d, String s,boolean isVisited[][]){

        if(a<0 || b<0 || a>c || b>d) return;
        if(isVisited[a][b]==true) return;
        if(a==c && b==d){
            System.out.println(s);
            return;
        }
        isVisited[a][b]=true;
        printMazePathIn4Direction(a+1,b,c,d,s+"D",isVisited);  //Down
        printMazePathIn4Direction(a,b+1,c,d,s+"R",isVisited);  //Right
        printMazePathIn4Direction(a-1,b,c,d,s+"U",isVisited);  //Up
        printMazePathIn4Direction(a,b-1,c,d,s+"L",isVisited);  //Left

        isVisited[a][b]=false;   // backTracking

    }

    static void allPermutationInString(String s, String currAns,ArrayList<String> arr){
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

    static void kCombinationInArary(int arr[], int k, int idx, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans){
        if(idx==arr.length) return;
        if(k==1){
            for(int i=idx; i<arr.length; i++){
                curr.add(arr[i]);
                ArrayList<Integer> a = (ArrayList)curr.clone();
                ans.add(a);
                curr.remove(curr.size()-1);
            }
            return;
        }

        for(int i=idx; i<=arr.length-k; i++){
            curr.add(arr[i]);
            kCombinationInArary(arr,k-1,i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
    }

    static void KConsecutiveSequence(int arr[],int k, ArrayList<Integer> curr){
        int n = arr.length;

        for(int i=0; i<=n-k; i++){
            for(int j=i; j<i+k; j++){
                curr.add(arr[j]);
            }

            System.out.print(curr+" ");
            curr.clear();
        }

    }


    static void kCombinationInArarySum(int arr[], int k, int idx, ArrayList<Integer> curr, ArrayList<Integer> ans){
        if(idx>=arr.length) return;
        if(k==1){
            for(int i=idx; i<arr.length; i++){
                curr.set(0,curr.get(0)+arr[i]);
                ans.add(curr.get(0));
                curr.set(0,curr.get(0)-arr[i]);
            }
            return;
        }

        for(int i=idx; i<=arr.length-k; i++){
            curr.set(0,curr.get(0)+arr[i]);
            kCombinationInArarySum(arr,k-1,i+1,curr,ans);
            curr.set(0,curr.get(0)-arr[i]);
        }
    }




    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        int n = arr.length;

        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        curr.add(0);

        int sum = 0;
        for(int i=1; i<=n; i++){
            kCombinationInArarySum(arr,i,0,curr,ans);
        }

        System.out.println(ans);


    }
}
