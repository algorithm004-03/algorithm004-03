package com.company.leetcode.editor.cn;
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
// count = 2
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int maxIndex = nums[0];
        int current = 1;
        int steps = 1;
        while (maxIndex < nums.length - 1) {

            int nextMax = maxIndex;
            for (int i = current; i <= maxIndex; i++) {
                nextMax = Math.max(nums[i] + i,nextMax);
            }
            steps++;
            current = maxIndex;
            maxIndex = nextMax;
        }
        return steps;
    }

    public int jump1(int[] nums) {
        int end = 0;
        int maxIndex = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(nums[i] + i,maxIndex);
            if (i == end) {
                steps++;
                end = maxIndex;
            }
        }

        return steps;
    }

    public int jump2(int[] nums) {

        int position = nums.length - 1;
        int steps = 0;
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }

        return steps;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] nums = new int[]{2,3,1,1,4};
//        System.out.println(s.jump(nums));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
