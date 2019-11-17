
/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 1.0 贪心算法是默写，递归方法是根据贪心算法自己想到的
 */
public class LeetCode_55_593 {

    private static final int TWO = 2;

    public boolean canJumpByForward(int[] nums) {
        int length = nums.length;
        if (length < TWO) {
            return true;
        }
        int toJump = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (toJump == 0) {
                return false;
            }
            toJump = Math.max(toJump - 1, nums[i]);
        }
        return true;
    }

    public boolean canJumpByBack(int[] nums) {
        int length = nums.length;
        if (length < TWO) {
            return true;
        }
        int position = length - 1;
        for (int i = length - TWO; i >= 0; i--) {
            if (nums[i] + i >= position) {
                position = i;
            }
        }
        return position == 0;
    }

    public boolean canJumpByRecursion(int[] nums) {
        if (nums.length < TWO) {
            return true;
        }
        return canJumpByRecursion(1, nums[0], nums);
    }

    private boolean canJumpByRecursion(int level, int toJump, int[] nums) {
        // terminator
        if (level > nums.length - TWO || toJump == 0) {
            return toJump > 0;
        }
        // process and drill down
        toJump = Math.max(toJump - 1, nums[level]);
        return canJumpByRecursion(level + 1, toJump, nums);
    }

}
