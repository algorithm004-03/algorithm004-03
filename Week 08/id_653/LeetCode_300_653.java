class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            int left = 0,right = piles;
            // 通过二分法将 val 放入堆中

            while (left<right) {
                int mid = (left+right)>>1;
                if (top[mid]<val) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            if (left==piles) {
                piles++;
            }
            top[left] = val;
        }
        return piles;
    }
}