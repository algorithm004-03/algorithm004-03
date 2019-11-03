//26删除排序数组的重复项

class Solution {
	
    //解法1：双指针 
	//时间复杂度O(n)
	//空间复杂度O(1)
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1;j<nums.length;j++) {
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}