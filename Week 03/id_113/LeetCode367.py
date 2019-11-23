class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num == 0:
            return False

        left = 1
        right = num

        while left <= right:
            mid = left + (right - left) // 2

            if mid ** 2 == num:
                return True
            elif mid ** 2 < num:
                left = mid + 1
            else:
                right = mid - 1

        return False
