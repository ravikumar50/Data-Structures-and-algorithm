package Graph;

public class CycleDetectionQuestionGoogle {
    public static void main(String[] args) {

        char arr[][] = {{'R','R','D','D'},
                        {'L','U','D','L'},
                        {'D','D','L','R'},
                        {'L','R','D','D'},
                        {'D','R','R','R'}};

        int n = arr.length;
        int m = arr[0].length;

        // 2nd approach is how we find cycle in linked List
        // same thing can be used in this question
        // just take slow and fast
        // whenever slow == fast, its means we have found a cycle
        // otherwise we can reach the destination

        int steps = 0;
        int i = 0;
        int j = 0;
        while(steps<n*m){
            if(i==n-1 && j==m-1){
                System.out.println("Reached");
                return;
            }

            if(arr[i][j]=='R') j++;
            else if(arr[i][j]=='L') j--;
            else if(arr[i][j]=='U') i--;
            else i++;

            steps++;
        }

        System.out.println("Cannot reached");
    }
}
