class Solution(object):
    def hammingWeight(self, n):
        """
        位1的个数：https://leetcode-cn.com/problems/number-of-1-bits/submissions/
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            n &= n - 1
            count += 1
        return count