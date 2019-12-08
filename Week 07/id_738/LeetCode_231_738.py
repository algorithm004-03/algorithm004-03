class Solution(object):
    def isPowerOfTwo(self, n):
        """
        2的幂：https://leetcode-cn.com/problems/power-of-two/

        :type n: int
        :rtype: bool
        """
        # 2的幂次的二进制，只有一位为1，其他位0
        return n != 0 and n & (n - 1) == 0
        