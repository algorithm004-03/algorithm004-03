/*
 * @lc app=leetcode.cn id=125 lang=java
 *  双指针法
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    private boolean isCharOrNum(char ch) {
        return ((ch >= 'a') && (ch <= 'z')) ||
                ((ch >= 'A') && (ch <= 'Z')) ||
                ((ch >= '0') && (ch <= '9'));
    }

    private boolean isChar(char ch) {
        return ((ch >= 'a') && (ch <= 'z')) ||
                ((ch >= 'A') && (ch <= 'Z'));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        if ((s.length() == 0) || (s.length() == 1)) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        char ch1, ch2;
        while (i < j) {
            ch1 = s.charAt(i); ch2 = s.charAt(j);
            if (!isCharOrNum(ch1)) {
                i++;
                continue;
            }

            if (!isCharOrNum(ch2)) {
                j--;
                continue;
            }

            if (ch1 != ch2) {
                if ( ! (isChar(ch1) && isChar(ch2) && Math.abs(ch1-ch2) == Math.abs('A' - 'a')) ) {
                    return false;
                }
            }

            i++; j--;
        }

        return true;
    }
}
// @lc code=end

