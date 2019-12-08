/*

思路
贪心策略
先用dp算法计算每一个位置之前所有节点中能够到达后续节点最远的位置，得到maxLen数组
题目说了最后一定可以到终点
所以每跳一步，都让可达的范围尽量远，最后跳的步数就是最少的

*/

class Solution {
    public int jump(int[] nums) {
        int[] maxLen = new int[nums.length];    // maxLen[i]表示前i个元素能跳到最远的位置

        maxLen[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLen[i] = Math.max(maxLen[i-1], i + nums[i]);
        }

        int step = 0;       // 当前能跳到的最远的位置的最少步数
        int i = 0;

        while (true) {
            if (i >= nums.length-1) {
                return step;
            }

            i = maxLen[i];
            step++;
        }
    }

    public static void main(String[] args) {
        new Solution().jump(new int[] {1,1,1,1});
    }
}
