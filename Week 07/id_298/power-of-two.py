class Solution(object):
  def isPowerOfTwo(self, n):
    """
    :type n: int
    :rtype: bool
    """
    return n > 0 and n & (n - 1) == 0

# 首先如果是2的幂次方，则只有一位为1，其它全为0
# n & (n -1) 是类似0b1000 和0b0111,按位与为0,则一定是2的幂次方


