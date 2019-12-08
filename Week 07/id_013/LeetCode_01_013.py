"""
第1题：191. 位1的个数
"""

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            n = n&(n-1)
            count += 1
        return count