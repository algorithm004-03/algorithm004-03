
/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * dp
 * a. 找重复子问题
 * f(i) = max( a(i), f(i+1) + a(i) );
 * b. 状态数组
 * dp[i]
 * c. dp方程
 * dp[i] = max(a[i], dp[i+1] + a[i])
 *
 * @author jaryoung
 */
public class LeetCode_53_593 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i], dp[i + 1] + nums[i]);
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[0] < dp[i]) {
                dp[0] = dp[i];
            }
        }
        return dp[0];
    }
