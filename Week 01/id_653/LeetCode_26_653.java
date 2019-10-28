class Solution {
    /**
     * @param nums
     * @return
     * @javadoc 双指针法思路：前序指针负责收集前进需找新元素，当发现新元素，后序指针前进，收集新元素
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}