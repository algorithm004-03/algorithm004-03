/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int>  res(2,0);
        for(int i=0; i<nums.size();++i)
        {
            for(int j = i+1; j<nums.size();++j)
            {
                if(nums[j] == target - nums[i])
                {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
};
// @lc code=end

