#include <stdio.h>

/*
思路：
用Hash保存每一个字符出现的频次，遍历s中所有字符统计字符频次，然后遍历t中所有字符
将hash中对应字符的频次进行递减，t中出现任何不在hash中的字符或者有任何一个字符频次
减少到0以下，都说明t和s不匹配，可以立即判断失败，不必在最后去统计是不是所有字符的频次
都减到0
自己用数组实现Hash比起用库里面的hash表要快一些
 */

#include <string>
#include <unordered_map>
using namespace std;


class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> char2cnt;

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (char2cnt.find(s[i]) == char2cnt.end()) {
                char2cnt[s[i]] = 1;
            } else {
                char2cnt[s[i]]++;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (char2cnt.find(t[i]) == char2cnt.end()) {
                return false;
            }

            char2cnt[t[i]]--;
            if (char2cnt[t[i]] < 0) {
                return false;
            }
        }

        return true;
    }
};