/*
 * @lc app=leetcode id=49 lang=cpp
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> hashMap;
        for(auto s: strs)
        {
            string temp = s;
            sort(temp.begin(),temp.end());
            hashMap[temp].push_back(s);
        }
        int len = hashMap.size();
        vector<vector<string>> ans(len);
        int index = 0;
        for(auto i :hashMap)
        {
            ans[index] = i.second;
            ++ index;
        }
        return ans;
    }
};
// @lc code=end

