/*
 * @lc app=leetcode id=47 lang=cpp
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
public:
   vector<int> nums;
    vector<vector<int>> res;
    vector<int> path;
    
    void DFS(int level,vector<bool>& visitor){
        if(level < 0){
            res.push_back(path);
            return;
        }
        for(int i = 0;i<nums.size();i++){
            if(visitor[i] == true || i>0 && nums[i] == nums[i-1]&&!visitor[i-1])
                continue;
            visitor[i] = true;
            path.push_back(nums[i]);
            DFS(level-1,visitor);
            path.pop_back();
            visitor[i] = false;
        }
    }
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<bool> visitor(nums.size(),false);
        this->nums = nums;
        DFS(nums.size()-1,visitor);

        return res;
        
    }
};
// @lc code=end

