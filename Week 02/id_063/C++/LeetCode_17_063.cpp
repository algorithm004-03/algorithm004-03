
/*
输入数字从左到右每一个代表递归的一层，每一层递归顺序选择本层数字对应的字符中的一个，然后继续下一层
递归，递归深度到数字总数时候保存结果并且进行回溯即可
*/

#include <string>
#include <vector>
using namespace std;

class Solution {
    static string char_map[];

public:

    void dfs(vector<string>& result, char* path, string& digits, int cur_level, int max_level) {
        if (cur_level == max_level) {
            result.emplace_back(path, max_level);
            return;
        }

        string chars = char_map[digits[cur_level]-'0'];
        for (int i = 0; i < chars.length(); i++) {
            path[cur_level] = chars[i];
            dfs(result, path, digits, cur_level + 1, max_level);
        }
    }

    vector<string> letterCombinations(string digits) {
        char* path = new char[digits.length()];
        vector<string> result;

        if (digits.length() == 0) {
            return result;
        }

        dfs(result, path, digits, 0, digits.length());
        delete[] path;
        return result;
    }
};


string Solution::char_map[] = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
};