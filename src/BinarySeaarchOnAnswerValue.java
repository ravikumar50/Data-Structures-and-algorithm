import java.util.Scanner;


public class BinarySeaarchOnAnswerValue {

    static boolean isDivisionPossible(int arr[], int m, int maxchocolate){
           int numofStudents=1;   // current student
           int choco=0;    // number of chocolates current student have
           for(int i=0; i<arr.length; i++){
               if(arr[i]>maxchocolate) return false;
               if(choco+arr[i]<=maxchocolate){
                   choco+=arr[i];
               }else{
                   numofStudents++;
                   choco=arr[i];
               }
           }
           if(numofStudents>m) return false;
           return true;
    }


    static int chocolateProblem(int arr[], int m) {
        int n = arr.length;
        if (n < m) return -1;

        int st = 1;
        int end = (int) 1e9;
        int ans = 0;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isDivisionPossible(arr, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    static boolean isArrangementPossible(int arr[], int m, int distance) {
        int Kidsplaced = 1;
        int lastkid = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] - lastkid >= distance) {
                Kidsplaced++;
                lastkid = arr[i];
            }
        }
            if (Kidsplaced >= m) return true;
            return false;
    }


    static int raceTrackProblem(int arr[],int m){
        int n = arr.length;
        int st =0;
        int end = (int)10e9;
        int ans = 0;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(isArrangementPossible(arr,m,mid)){  // can m kid be placed such that the distance between 2 kids is not less than mid;
                ans = mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of track");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter distance of each track");
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter number of Students");
        int m = sc.nextInt();

        int ans = raceTrackProblem(arr,m);

        System.out.println(ans);
    }
}
