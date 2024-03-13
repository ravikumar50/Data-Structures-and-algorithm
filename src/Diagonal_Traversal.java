public class Diagonal_Traversal {
    static int[] helper(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int ans[] = new int[n*m];
        int idx = 0;
        int ur=0,uc=0;
        int br=0,bc=0;
        while(idx<(n*m)) {
            if ((ur + uc) % 2 == 0) {
                int i = br, j = bc;
                while (true) {
                    ans[idx++] = arr[i][j];
                    if (i == ur) break;
                    i--;
                    j++;
                }
            } else {
                int i = ur, j = uc;
                while (true) {
                    ans[idx++] = arr[i][j];
                    if (i == br) break;
                    i++;
                    j--;
                }
            }
            if(uc==m-1) ur++;
            else uc++;

            if(br==n-1) bc++;
            else br++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2,3},
                {4,5,6}};
        int ans[] = helper(arr);
        for(var a : ans) System.out.print(a+" ");
    }
}
