class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 定义dp[i]为s[0...i]，如果是连续有效括号，则为括号数，如果不是连续有效括号则为0
        # 那么有如下规律：
        # 1. s[i]为(，则可以忽略s[i]，因为(不可能与之前成为有效括号对，但是可能与后面构成连续有效括号串，从而导致连接两个有效括号串的效果
        # 2. s[i]为)，则如果s[i - 1]为(，则dp[i] = dp[i - 2] + 2
        # 3. s[i]为)，则如果s[i - 1]为)，则当s[i-1]之前如果有(也可以没有)连续有效括号，并且在s[i-1]之前的连续有效括号再前一个位置的字符必须是(，才能使s[i]融入连续有效括号串中。否则s[i]必然不能与前面的字符串构成连续有效括号串
        dp = [0] * len(s)
        res = 0
        for i in range(1, len(s)):
            if s[i] == ")":
                if s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 2
                elif s[i - 1] == ")" and i - dp[i - 1] - 1 >=0 and s[i - dp[i - 1] - 1] == "(":
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 1 - 1]
                if res < dp[i]:
                    res = dp[i]
        return res





