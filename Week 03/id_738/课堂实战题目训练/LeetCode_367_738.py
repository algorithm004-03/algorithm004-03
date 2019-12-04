class Solution(object):
    def isPerfectSquare(self, num):
        """
        有效的完全平方数：https://leetcode-cn.com/problems/valid-perfect-square/submissions/
        
        :type num: int
        :rtype: bool
        """
        # 二分法直接求解Log(n)
        left, right = 1, num
        while left <= right:
            mid = left + (right - left) // 2
            print(mid)
            mid2 = mid * mid
            if mid2 == num:
                return True
            elif mid2 > num:
                right = mid - 1
            else:
                left = mid + 1
        return False

        