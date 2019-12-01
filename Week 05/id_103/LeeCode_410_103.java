/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        long ans = 0;
        long L = 0,R = 1;
        for(int i = 0;i < nums.length;i++) 
            R += nums[i];
        while(L < R) {
            long mid = (L + R) / 2;
            if(guess(mid,nums,m)) {
                ans = mid;
                R = mid;
            }
            else
                L = mid + 1;
        }
        return (int)ans;
    }
    public boolean guess(long mid,int[] nums,long m) {
        long sum = 0;
        for(int i = 0;i < nums.length;i++) {
            if(sum + nums[i] > mid) {
                --m;
                sum = nums[i];
                if(sum > mid)
                    return false;
            }
            else
                sum += nums[i];
        }
        return m > 0;
    }
}
// @lc code=end

