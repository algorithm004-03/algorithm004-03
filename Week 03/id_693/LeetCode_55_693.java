package id_693;

import org.junit.Assert;

/**
 * @Desc 55. 跳跃游戏    https://leetcode-cn.com/problems/jump-game/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/02
 */
public class LeetCode_55_693 {
    //贪心思路，从后往前看，太他妈神奇了
    //获得当前的值，加上需要的步数（i),如果大于等于当前的步数，那么肯定能跳出去，那就更新数据。就继续下去
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }

    //网上看到的c++写法，很秀。但是因为计算步骤多，效率没上一个快
    /*
            1、如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
            2、可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
            3、如果可以一直跳到最后，就成功了。
     */
    public boolean canJump2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Assert.assertTrue(new LeetCode_55_693().canJump(new int[]{2, 5, 0, 0}));
        Assert.assertTrue(new LeetCode_55_693().canJump(new int[]{2, 0, 0}));
        Assert.assertTrue(new LeetCode_55_693().canJump(new int[]{2, 0}));
        Assert.assertFalse(new LeetCode_55_693().canJump(new int[]{0, 1}));
        Assert.assertTrue(new LeetCode_55_693().canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(new LeetCode_55_693().canJump(new int[]{3, 2, 1, 0, 4}));


        Assert.assertTrue(new LeetCode_55_693().canJump2(new int[]{2, 5, 0, 0}));
        Assert.assertTrue(new LeetCode_55_693().canJump2(new int[]{2, 0, 0}));
        Assert.assertTrue(new LeetCode_55_693().canJump2(new int[]{2, 0}));
        Assert.assertFalse(new LeetCode_55_693().canJump2(new int[]{0, 1}));
        Assert.assertTrue(new LeetCode_55_693().canJump2(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(new LeetCode_55_693().canJump2(new int[]{3, 2, 1, 0, 4}));
    }
}
