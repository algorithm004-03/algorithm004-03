/*
 * @lc app=leetcode id=26 lang=cpp
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size()==0) return 0;
        // int i = 0;
        // //if nums [j] == nums[i]--> ++j
        // for(int j=1;j<nums.size();++j)
        // {
        //     if(nums[j] != nums[i])
        //     {
        //         i++;
        //         nums[i] = nums[j];
        //     }
        // }
        // return i+1;
        
        //2. the first element do not need to be considered
        int i = 1;
        for (int j = 1; j < nums.size(); ++j) {
        if (nums[i - 1] != nums[j]) {
            nums[i++] = nums[j];
        }
        
    }
    return i;
    }
    
};
// @lc code=end

