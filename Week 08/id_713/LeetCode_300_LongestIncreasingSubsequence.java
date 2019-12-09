package id_713;

/**
 * 300. 最长上升子序列
 */
public class LeetCode_300_LongestIncreasingSubsequence {

    /*
    给定一个无序的整数数组，找到其中最长上升子序列的长度。

    示例:

    输入: [10,9,2,5,3,7,101,18]
    输出: 4
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

    说明:

        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2) 。

    进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */



    /*


    参考: https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/

    朴素动态规划:
        状态定义:
            dp[i]的值表示 nums 前i个数字的最长子序列长度
        转移方程
            设 j 属于 [0, i), 考虑每轮计算新的dp[i]时, 遍历[0, i)列表区间, 做以下判断
            1. 当 nums[i] > nums[j]时, nums[i]可以接在nums[j]之后, 此情况下最长上升子序列长度为 dp[j] + 1
            2. 当 nums[i] <= nums[j]时, nums[i] 无法接在nums[i]之后, 此情况上升序列不成立, 跳过

            上述所有1情况下 计算出的 dp[j] + 1的最大值, 为直到i的上升子序列长度(dp[i])
                实现方式为 遍历j时, 每轮执行 dp[i] = max(dp[i], dp[j] + 1)

            转移方程: dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
            初始状态: dp[i]所有元素置1, 含义是: 每个元素都至少可以单独成为子序列, 长度为1
            返回值: 返回dp数组中最大值, 即可得到全局最长上升子序列长度

    高级动态规划
        1. 动态规划中, 通过线性遍历来计算dp的复杂度无法降低
        2. 每轮计算中, 需要通过线性遍历 [0, k)区间元素来得到 dp[k]. 考虑, 是否可以通过重新设计状态定义, 使整个dp为一个排序列表
            这样在计算每个dp[k]时, 就可以通过二分查找法遍历 [0, k)区间元素, 将此部分复杂度有 O(N) 降低至 O(logN)

        新状态定义
            维护一个列表 dp, 其中每个元素 dp[k]的值代表 长度为 k+1的子序列尾部元素值
            如 [1,4,6]序列, 长度为1,2,3的子序列尾部元素值分别为 dp = [1,4,6]

        状态转移设计
            设常量数字N, 和随机数x, 可以推出: 当N越小时, N < x的纪律越大
                如 N = 0 比 N = 1000更可能满足  N < x

            在遍历计算每个 tails[k]，不断更新长度为 [1,k]的子序列尾部元素值，始终保持每个尾部元素值最小 （例如 [1,5,3]]， 遍历到元素 555 时，长度为 222 的子序列尾部元素值为 555；当遍历到元素 333 时，尾部元素值应更新至 333，因为 333 遇到比它大的数字的几率更大）。





    [10  9   2   5   3   7   21  18]

    [0  0   0   0   0   0   0   0]
    [10  0   0   0   0   0   0   0]
    [9  0   0   0   0   0   0   0]
    [2  0   0   0   0   0   0   0]
    [2  5   0   0   0   0   0   0]
    [2  3   0   0   0   0   0   0]
    [2  3   7   0   0   0   0   0]
    [2  3   7   21   0   0   0   0]
    [2  3   7   18   0   0   0   0]

    数组的长度, 即为最大上升子序列
     */

    public int lengthOfLIS(int[] nums) {

        int[] tails = new int[nums.length];
        int res = 0;

        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }

        return res;
    }
}
