class Solution(object):
    def numDecodings(self, s):
        """
        解码方法：https://leetcode-cn.com/problems/decode-ways/

        :type s: str
        :rtype: int
        """
        if s[0] == "0":
            return 0
        if len(s) == 1:
            return 1
        a, b = 1, 0
        if s[1] != "0": b += 1
        if s[0] == "1" or (s[0] == "2" and "0" <= s[1] <= "6"):
             b += 1
        for i in range(2, len(s)):
            temp = 0
            if s[i] != "0":
                temp = b
            if s[i - 1] == "1" or (s[i - 1] == "2" and "0" <= s[i] <= "6"):
                temp += a
            a, b = b, temp
        return b


