import javax.lang.model.type.IntersectionType;
import java.util.*;

public class Job_Schedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Jobs to be done");
        int n = sc.nextInt();
        int maxLength = -1;

        ArrayList<int[]> jobs = new ArrayList<>();
        System.out.println("Enter the deadline and profit of "+n+" Jobs");
        for(int i=0; i<n; i++){
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new int[]{i,deadline,profit});
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

n = 9

7 15
2 20
5 30
3 18
4 18
5 10
2 23
7 16
3 25

profit = 147
ans = [2,8,6,1,4,7,0]
 */
