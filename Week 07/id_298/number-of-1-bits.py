class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
          count += n & 1
          n >>= 1
        return count
# n & 1 如果n的二进制最后一位是1，则结果是1，如果是0则结果是0
# 上一步判断一位，右移一位，不断循环知道n为0
