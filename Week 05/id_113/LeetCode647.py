class Solution:
    def countSubstrings(self, s: str) -> int:
        if not s:
            return 0
        res = len(s)
        dp = [[i,i+1] for i in range(len(s))]
        for i in range(1, len(s)):
            for j in dp[i-1]:
                if j-1 >= 0 and s[j-1] == s[i]:
                    res += 1
                    dp[i].append(j-1)
        return res
