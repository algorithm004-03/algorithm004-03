class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
      ans = 0
      for _ in range(32):
        ans = (ans << 1) + (n & 1)
        n >>= 1
      return ans

# 定义ans保存颠倒后的值
# n & 1 是取n的最后一位，追加在向左移位后的ans的末位
# n 右移1位直到32位处理完
