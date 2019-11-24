package Week03;

/**
 * @Date 2019/11/2.
 * @see <a href="55">https://leetcode-cn.com/problems/jump-game/</a>
 * 跳跃游戏
 */
public class LeetCode_55_558 {
    /**
     * 核心步骤：
     * 1、逆向（从后向前遍历）
     * 2、nums[i] + i 当前位置最多可以跳的步数
     */
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int endIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= endIndex) {
                endIndex = i;
            }
        }
        return endIndex == 0;
    }
}
