/*
 * @lc app=leetcode id=66 lang=cpp
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        //two situation: no need to add one digit || 999->1000
        for(int  i = digits.size()-1;i>=0;i--)
        {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] !=0) return digits;
        }
        int size = digits.size();
         vector<int> new_v(size+1,0);
        new_v[0] = 1;
        return  new_v;
    }
};
// @lc code=end

