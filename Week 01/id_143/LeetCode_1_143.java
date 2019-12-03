import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 方法一:暴力双循环
 * 方法二:缓存+循环
 * 方法三:边循环边缓存
 * 方法四:主体思想 两边向中夹迫,但原始数组无序,需要处理好多事情。
 * 方法五:&位运算+数组缓存(其实不推荐)
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] b = new int[nums.length];

        System.arraycopy(nums,0,b,0,nums.length);
        Arrays.sort(nums);

        int res[] = new int[2];
        int k1 = nums.length - 1;
        for (int i = 0; i >= 0 && i <= k1; ) {
            if(nums[i] + nums[k1] == target){
                for(int j=0;j<b.length;j++){
                    if(b[j]==nums[i]){
                        res[0] = j;
                        break;
                    }
                }
                for(int j=b.length-1;j>=0;j--){
                    if(b[j]==nums[k1]){
                        res[1] = j;
                        break;
                    }
                }
                return res;
            } else if (nums[i] + nums[k1] < target) {
                i++;
            } else {
                k1--;
            }
        }
        return null;
    }
}
// @lc code=end

