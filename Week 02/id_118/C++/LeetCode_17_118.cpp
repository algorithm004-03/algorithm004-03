#include <iostream>
#include <vector>
#include <cassert>
#include <unordered_map>

using namespace std;


class Solution {
private:

    // mapping letter and number
    const string letterMap[10] = {
            " ",
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

    // res to store the result
    vector<string> res;

    // s is the current string from [0,...,index-1]
    // at the current index level, just look for digits[index] => to get digits[0,...,index]
    void findCombination(const string &digits, int index, const string &s) {

        // terminator
        if (index == digits.size()) {
            // here s is one solution
            // save s to res
            res.push_back(s);
            return;
        }

        // get the char of the digit
        char c = digits[index];
        // make sure the char is between 0 and 9, also 1 doesn't have any char
        assert(c >= '0' && c <= '9' && c != '1');
        // get letters based on the current number
        string letters = letterMap[c - '0'];
        for (int i = 0; i < letters.size(); ++i) {
            // drill down
            findCombination(digits, index + 1, s + letters[i]);
        }

        return;
    }

public:
    vector<string> letterCombinations(string digits) {
        // initialization
        res.clear();

        // edge case, empty string input => empty output, not empty string output
        if (digits == "") {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }
};

//leetcode submit region end(Prohibit modification and deletion)
int main() {
    vector<string> res = Solution().letterCombinations("4567");
    for (int i = 0; i < res.size(); ++i) {
        cout << res[i] << endl;
    }
    return 0;
};

