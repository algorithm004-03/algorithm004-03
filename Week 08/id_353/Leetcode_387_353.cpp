/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
public:
    int firstUniqChar(string s) {
        std::map<char, int> char_count;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char_count[s[i]]++;
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (char_count[s[i]] == 1)
                return i;
        }
        return -1;
    }
};
// @lc code=end

