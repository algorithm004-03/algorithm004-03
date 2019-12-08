class Solution(object):
    def hammingWeight(self, n):
        count = 0
        while n != 0:
            # 清除最低位的1
            n &= (n - 1)
            count += 1
        return count


s = Solution()
print(s.hammingWeight(0b00000000000000000000000000001011))
