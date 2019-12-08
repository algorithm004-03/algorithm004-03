/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        int pre = 1, curr = 1; 
        for (int i = 1; i < s.size(); i++) {
            int tmp = curr;
            if (s[i] == '0') {
                if (s[i - 1] == '1' || s[i - 1] == '2') {
                    curr = pre;
                }
                else {
                    return 0;
                }
            }
            else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6')) {
                curr += pre;
            }
            pre = tmp;
        }
        return curr;
    }
};
// @lc code=end

