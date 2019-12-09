class Solution(object):
    def longestPalindrome(self, s):
        """
        最长回文子串：https://leetcode-cn.com/problems/longest-palindromic-substring/

        :type s: str
        :rtype: str
        """
        # 动态规划：
        # 这里只有一个字符串，不能定义一个二维dp状态，分别为一个字符串
        # 对于自身和自身比较的字符串，定义dp[i][j]表示s[i:j + 1]的状态，这里的状态就是是否是回文串:true, false
        # dp方程：s[i: j + 1]是回文串的条件就是：
        # s[i] == s[j]并且s[i + 1, j]也是回文串
        # dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
        length = len(s)
        dp = [[False] * length for _ in range(length)]
        res = ""
        for i in range(length)[::-1]:
            for j in range(i, length):
                dp[i][j] = (j - i <= 1 or dp[i + 1][j - 1]) and s[i] == s[j]
                res = s[i: j + 1] if dp[i][j] and len(res) < (j - i + 1) else res
        return res



