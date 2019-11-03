/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
#include <map>
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;

        std::map<char, int> mapS, mapT;
        for (char chs : s) {
            mapS[chs]++;
        }
        for (char cht : t) {
            mapT[cht]++;
        }        
        return mapS == mapT;

        // const int LETTERS = 26;
        // int arrs[LETTERS] = {0};
        // int arrt[LETTERS] = {0};
        // for (int i = 0; i < s.length(); i++) {
        //     arrs[s[i] - 'a']++;
        //     arrt[t[i] - 'a']++;
        // }
        // int j = 0;
        // for (; j < LETTERS; j++) {
        //     if (arrs[j] != arrt[j]) break;
        // }
        // return j == LETTERS;
    }
};
// @lc code=end

