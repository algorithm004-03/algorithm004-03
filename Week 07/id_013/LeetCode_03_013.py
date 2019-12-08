class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        MASK  = 1

        for i in range(32):
            if n & MASK:
                ans |= 1 << (31-i)
            MASK <<= 1

        return ans