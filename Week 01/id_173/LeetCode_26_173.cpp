/*
 * 26. 删除排序数组中的重复项
 */

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.empty())
            return 0;
        
        int j = 0;
        for(int i=1; i<nums.size(); ++i) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return j+1;
    }
};