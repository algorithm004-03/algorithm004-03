class Solution(object):
    def hammingWeight1(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            count += n&1
            n >>= 1
        return count

    def hammingWeight2(self, n):
        count = 0
        while n:
            res = n % 2
            if res == 1:
                count += 1
            n //= 2
        return count