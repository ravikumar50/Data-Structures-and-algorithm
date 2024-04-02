class Hello {
    public static int minimumSubarrayLength(int[] arr, int k) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int bitwiseOR = 0;

        for (int right = 0; right < n; right++) {
            bitwiseOR |= arr[right];

            while (bitwiseOR >= k && left <= right) {
                ans = Math.min(ans, right - left + 1);
                bitwiseOR ^= arr[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int helper(int[] arr, int k) {
        int n = arr.length;

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int x = 0;
            for(int j=i; j<n; j++){
                x = x|arr[j];
                if(x>=k){
                    ans = Math.min(ans,j-i+1);
                }
            }

        }
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }

    public static void main(String[] args) {
        int arr[] = {16,1,2,20,32};
        int k = 45;
       // System.out.println(minimumSubarrayLength(arr,k));
       // System.out.println(helper(arr,k));

        System.out.println(55|1);
    }
}
