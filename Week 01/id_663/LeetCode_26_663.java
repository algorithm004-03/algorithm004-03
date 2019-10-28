class Solution {
    public int removeDuplicates(int[] nums) {
        if (0 == nums.length)
            return 0;
        int distinctIdx = 0;
        for (int it = 1; it < nums.length; ++it) {
            if (nums[it] != nums[distinctIdx])
                nums[++distinctIdx] = nums[it];
        }
        return distinctIdx + 1;
    }
}

public class LeetCode_26_663 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2, 3}));
    }
}
