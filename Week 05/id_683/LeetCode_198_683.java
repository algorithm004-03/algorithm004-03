class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[][] a = new int[nums.length][2];
        a[0][0] = 0;
        a[0][1] = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
            a[i][1] = a[i - 1][0] + nums[i];
        }

        return Math.max(a[nums.length - 1][0], a[nums.length - 1][1]);
    }
}