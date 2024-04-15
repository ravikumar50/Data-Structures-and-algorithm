class Solution {
    static Long reversedBits(long x) {
        // code here

        StringBuilder s = new StringBuilder(Long.toBinaryString(x));

        s.insert(0,"0".repeat(32-s.length()));
        System.out.println(s);

        Long ans = (long)0;
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='1'){
                ans = ans + (long)Math.pow(2,idx);
            }
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        long x = 5;
        System.out.println(reversedBits(x));

    }
}