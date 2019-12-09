/*
 * @lc app=leetcode id=283 lang=cpp
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        //pointer i:current position ready to insert;
        //pointer j:traverse all elements in the vector
        int i,j;
        i=0;
        for(j = 0;j<nums.size(); ++j)
        {
            //nums[j] !=0-> nums[i]=nums[j];++i;
            if(nums[j]!=0)
            {
                nums[i] = nums[j];
                ++i;
            }
        } 
        //add zeros
        for(int k = i;k<nums.size();++k)
        {
            nums[k]=0;
        }
    }
};
// @lc code=end

