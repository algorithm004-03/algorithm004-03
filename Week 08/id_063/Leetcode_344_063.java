
/*

思路
简单字符串处理

 */

class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r) {
            char t = s[l]; s[l] = s[r]; s[r] = t;
            l++; r--;
        }
    }
}
