class Solution:
    # 颠倒二进制位： https://leetcode-cn.com/problems/reverse-bits/
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        # 目标：设最右边为第一位，将第i位移动到第 31 - i 位
        # 那么，循环i = {0...31}，取n的第i位加到结果值的第1位即可
        res = 0
        for _ in range(32):
            res <<= 1
            res += n & 1
            n >>= 1
        return res