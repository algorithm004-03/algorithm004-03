public class LeetCode_45_368 {

    /*给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    链接：https://leetcode-cn.com/problems/jump-game-ii*/

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int end = 0, furthest = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, nums[i] + i);
            if (i == end) {
                end = furthest;
                step++;
            }
        }
        return step;
    }
}
