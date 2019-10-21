public class Solution {
    public int RemoveDuplicates(int[] nums) {
        //bounds checking
        if (nums.Length < 2)
            return nums.Length;
        //double pointers
        int j = 0;
        for (int i = 1; i < nums.Length; i++) {
            if (nums[i] != nums[j] && i > ++j) {
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
