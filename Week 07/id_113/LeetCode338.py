class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        ans = []
        for n in range(num + 1):
            count = 0
            while n:
                count += n & 1
                n >>= 1
            ans.append(count)

        return ans