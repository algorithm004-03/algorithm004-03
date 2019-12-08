/*
 * @lc app=leetcode id=22 lang=cpp
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
public:
    void helper(int left, int right, string tmp, vector<string> &result) {
        if (left == 0 && right == 0) {
            result.push_back(tmp);
            return;
        }
        
        if (left>right || left<0 || right<0)  //左括号用的比右括号少
            return ;
      
        helper(left-1, right, tmp+'(', result);
        helper(left, right-1, tmp+')', result);
        
    }
    vector<string> generateParenthesis(int n) {
        vector<string>result;
        helper(n,n, "", result);
        return result;
    }
};

// @lc code=end

