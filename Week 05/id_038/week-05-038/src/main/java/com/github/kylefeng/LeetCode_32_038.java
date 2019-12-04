package com.github.kylefeng;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 *
 * @author kylefeng
 * @time 2019/11/13 14:18
 */
public class LeetCode_32_038 {

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 暴力算法：
     * 双指针截取字串，通过 isValid 函数判断该子串是否合法。
     * 最近子问题，就是截取字串，利用栈判断合法性。
     *
     * @param s
     * @return
     */
    public static int solution_brutal(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxlen = 0;
        int strLen = s.length();

        for (int i = 0; i < strLen; i++) {
            // 注意内层循环需要 <= 字符串长度，否则不会囊括字串最后一个字符
            for (int j = i + 2; j <= strLen; j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    /**
     * 基于递推公式：
     * 1. 若 s[i] == ')' 并且 s[i-1] = '('，即形如 "......()" 那么递推公式为
     * dp[i] = dp[i-2] + 2
     * <p>
     * <p>
     * 2. 若 s[i] == ')' 且 s[i-1] = ')'，即形如 "......))" 当 s[i - dp[i-1] -1] == '('
     * dp [i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
     *
     * @param s
     * @return
     */
    public static int solution_dp(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;

            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


}
