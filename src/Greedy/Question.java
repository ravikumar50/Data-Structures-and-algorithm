package Greedy;

import java.util.*;

public class Question {

    public static class Items{
        int box;
        int size;
        double units;
        Items(int box, int size, double units){
            this.box = box;
            this.size = size;
            this.units = units;
        }
    }

    public static class ItemsComparator implements Comparator<Items> {
        public int compare(Items p1, Items p2){
            if(p1.units>p2.units) return -1;
            else if(p1.units<p2.units) return 1;
            else return 0;
        }
    }


    static int knapsackFraction(int box[][], int truckSize){


        List<Items> arr = new ArrayList<>();
        for(int i=0; i<box.length; i++){
            Items p = new Items(box[i][0], box[i][1], (double)box[i][1]/(double)box[i][0]);

            arr.add(p);
        }

        arr.sort(new ItemsComparator());

        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i).box+" "+arr.get(i).size);
        }
        System.out.println();


        int i=0;
        int ans = 0;

        while(i<arr.size() && truckSize>0){
            Items p = arr.get(i);
            if(truckSize>p.box){
                ans+=p.size;
                i++;
                truckSize-=p.box;

            }
            else{
                ans+=(p.size/p.box)*truckSize;

                break;
            }
        }
        return ans;
    }


    static int maximumNumberOfMeetingInOneRoom(int st[], int end[]){
        List<Meeting> arr = new ArrayList<>();

        for(int i=0; i<st.length; i++){
            Meeting m = new Meeting(st[i],end[i]);
            arr.add(m);
        }

        arr.sort(new MeetingComparator());

        int curr = -1;
        int ans = 0;

        for(int i=0; i<arr.size(); i++){
            Meeting m = arr.get(i);
            if(curr<m.start){
                ans++;
                curr=m.end;
            }
        }
        return ans;
    }

    public static class Meeting{
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class MeetingComparator implements Comparator<Meeting>{
        public int compare(Meeting m1, Meeting m2){
            if(m1.end>m2.end) return 1;
            else if(m1.end<m2.end) return -1;
            else return 0;
        }
    }

    static String largestPallindromicNumber(String str){

        int arr[] = new int[10];

        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-48]++;
        }

        StringBuilder s = new StringBuilder();
        int oddCount = 0;
        int x = Integer.MIN_VALUE;

        for(int i=0; i<=9; i++){
            if(arr[i]%2!=0){
                oddCount++;
                if(oddCount>=2){
                    System.out.println("Not Possible to Make Pallindrome");
                    return " ";
                }
                int n = s.length();
                int freq = arr[i];

                if(arr[i]==1){
                    s.insert(n/2,String.valueOf(i));
                }else{
                   s.append(String.valueOf(i).repeat(freq/2));
                   s.insert(0,String.valueOf(i).repeat(freq/2));
                   x = i;
                }

            }else{
                int freq = arr[i];
                s.append(String.valueOf(i).repeat(freq/2));
                s.insert(0,String.valueOf(i).repeat(freq/2));
            }
        }
        if(x!=Integer.MIN_VALUE){
            s.insert(s.length()/2,String.valueOf(x));
        }
        return s.toString();
    }

    static int minimumCostToCutIntoSquare(int arr1[], int arr2[]){

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = arr1.length-1;
        int j = arr2.length-1;

        int ans = 0;
        int h = 1;
        int v = 1;

        while(i>=0 && j>=0){
            if(arr1[i]>=arr2[j]){
                ans+=arr1[i]*h;
                v++;
                i--;
            }else{
                ans+=arr2[j]*v;
                h++;
                j--;
            }
        }

        if(i>=0){
            while(i>=0){
                ans+=arr1[i]*h;
                i--;
            }
        }

        if(j>=0){
            while(j>=0){
                ans+=arr2[j]*v;
                j--;
            }
        }

        return ans;
    }

    static int nonOverlappingInterval(int inter[][]){
        List<Points> arr = new ArrayList<>();

        for(int i=0; i<inter.length; i++){
            Points p = new Points(inter[i][0],inter[i][1]);
            arr.add(p);
        }

        arr.sort(new PointComparator());

        Points prev = arr.get(0);
        int ans = 1;

        for(int i=1; i<arr.size(); i++){
            Points p = arr.get(i);

            if(p.start>=prev.end){
                prev = p;
                ans++;
            }
        }
        return inter.length-ans;

    }

    public static class Points{
        int start;
        int end;

        Points(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class PointComparator implements Comparator<Points>{
        public int compare(Points p1, Points p2){
            if(p1.end>p2.end) return 1;
            else if(p1.end<p2.end) return -1;
            else{
                if(p1.start<p2.start) return 1;
                else if(p1.start>p2.start) return -1;
                else return 0;
            }
        }
    }

    public static void main(String[] args) {

        int arr1[] = {2,1,3,1,4};
        int arr2[] = {4,1,2};

        System.out.println(minimumCostToCutIntoSquare(arr1,arr2));

    }
}
