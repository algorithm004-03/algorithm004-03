/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 *
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (43.30%)
 * Likes:    1139
 * Dislikes: 63
 * Total Accepted:    63.2K
 * Total Submissions: 145.9K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an
 * algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * Note:
 * If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * 
 * 
 * Examples: 
 * 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        //2019.11.15 二分搜索+贪心算法
        long left = 0,right = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            right += nums[i];
            if(left < nums[i]){
                left = nums[i];
            }
        }


        long ans = right;
        while(left <= right){
            long mid = (left+right) >> 1;
            long sum = 0;
            int cnt =1;
            for(int i=0;i<n;i++){
                if(sum + nums[i] > mid){
                    cnt++;
                    sum = nums[i];
                }else{
                    sum += nums[i];
                }
            }
            if(cnt <= m){
                ans = Math.min(ans, mid);
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return (int)ans;
    }
}
// @lc code=end

