package id_693;


import org.junit.Assert;

/**
 * @Desc 45. 跳跃游戏 II	https://leetcode-cn.com/problems/jump-game-ii/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/02
 */
public class LeetCode_45_693 {
    //参考顺藤摸瓜，每次看自己可以跳的范围最大值，然后跳到那个可跳跃的最大值位置，然后继续看下一个可跳跃范围
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Assert.assertEquals(2, new LeetCode_45_693().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
