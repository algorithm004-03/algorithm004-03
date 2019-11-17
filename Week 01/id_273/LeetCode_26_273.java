//26. 删除排序数组的重复项

//解法1：双指针		执行用时击败约100%
//思路：首先明确题目是排序数组, 定义慢指针i指向不重复序列的末尾, 每当快指针j指向一个与nums[i]不相等的元素就覆盖nums[++i]
//时间复杂度O(n)
//空间复杂度O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];      
        }
        return i + 1;
    }
}