import java.util.*;
public class Main {


    static List<Integer> helper(int cSize, int cTime, int sTime, String arr[]){
        HashSet<String> hp = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            if(q.contains(s)){
                ans.add(cTime);
                q.remove(s);
                q.add(s);
            }else {
                if (q.size() < cSize) {
                    q.add(s);
                } else {
                    q.remove();
                    q.add(s);
                }
                ans.add(sTime);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int cTime = 2;
        int cSize = 3;
        int sTime = 5;
        String arr[] = {"h","go","gm","ya","h","gm"};
        System.out.println(helper(cSize,cTime,sTime,arr));
    }
}
/*
0 3 5
5 6 2
6 8 4
2 8 3
4 5 1
2 4 2
 */
