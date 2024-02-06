import javax.lang.model.type.IntersectionType;
import java.util.*;

public class Job_Schedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxLength = -1;

        ArrayList<int[]> jobs = new ArrayList<>();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new int[]{id,deadline,profit});
            maxLength = Math.max(deadline,maxLength);
        }

        Collections.sort(jobs,(a,b)->(b[2]-a[2]));
        int space[] = new int[maxLength+1];
        Arrays.fill(space,-1);
        ArrayList<Integer> ans = new ArrayList<>();
        int profit = 0;
        for(int i=0; i<n; i++){
            int deadline = jobs.get(i)[1];
            int idx = -1;

            while(deadline>0){
                if(space[deadline]==-1){
                    space[deadline]=1;
                    profit+=jobs.get(i)[2];
                    ans.add(jobs.get(i)[0]);
                    break;
                }
                deadline--;
            }
        }
        System.out.println(ans);
        System.out.println(profit);
    }
}

/*
0 7 15
1 2 20
2 5 30
3 3 18
4 4 18
5 5 10
6 2 23
7 7 16
8 3 25
 */
