class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        while (num >= 0) {
            int temp = num;
            while (temp != 0) {
                temp &= temp-1;
                ans[num]++;
            }
            num--;
        }
        return ans;
    }
}