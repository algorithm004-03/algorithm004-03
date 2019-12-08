/*
 * 55. 跳跃游戏
 */

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.empty())
            return true;

        int endPos = nums.size()-1;

        for(int i=endPos; i>=0; --i) {
            if(i+nums[i] >= endPos)
                endPos = i;
        }

        return endPos == 0;
    }
};