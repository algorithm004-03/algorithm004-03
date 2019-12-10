class Solution:
    def longestValidParentheses(self, s: str) -> int:
        """
        方法？dp
        分两种情况
        1 () 这种直接+2，dp[i-2] = 上个有效括号最大长度的值。
        2 )) 如果是有效的 ——> 前一个 )，必须是有效的 ——> dp[i-1] = 上个有效括号最大长度的值。
          后一个 )，必然有一个 ( 在 i - dp[i-1] - 1 与之相呼应。
          然后+2 还不要忘了之前的有效括号最大长度的值——i - dp[i-1] - 2

        """
        # 特判
        if len(s) == 0:
            return 0
        dp = [0 for i in range(len(s))]
        for ids in range(len(s)):
            # 有效括号不可能是一位，所以从第二位判断
            if ids > 0 and s[ids] == ')':
                # 前一个是 (
                if s[ids - 1] == '(':
                    # 前面的最大
                    dp[ids] = dp[ids - 2] + 2
                # ids - dp[ids-1] -1 >=0——要存在不能超出索引
                # ids - dp[ids-1] - 1 必须有个(与之相呼应
                elif s[ids - 1] == ')' and ids - dp[ids - 1] - 1 >= 0 and s[ids - dp[ids - 1] - 1] == '(':
                    # dp[ids - dp[ids - 1] - 2] —— 之前的有效括号最大长度的值
                    dp[ids] = dp[ids - 1] + 2 + dp[ids - dp[ids - 1] - 2]
        return max(dp)


s = Solution()
print(s.longestValidParentheses('")()())"'))
