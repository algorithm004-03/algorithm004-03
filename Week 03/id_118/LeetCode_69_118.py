# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 10/31/2019

class Solution:
    """
    This is the binary search solution
    Time: O(logn)
    Space: O(1)
    """

    def mySqrt(self, x: int) -> int:
        # edge case
        if x <= 1:
            return x
        l, r = 0, x
        while l < r:
            mid = l + (r - l) // 2
            if mid ** 2 <= x < (mid + 1) ** 2:
                return mid
            elif x < mid ** 2:
                r = mid
            else:
                l = mid + 1


class Solution2:
    """
    This is Integer Newton solution
    will have TLE issue
    """

    def mySqrt(self, x: int) -> int:
        r = x
        while x < r ** 2:
            r = (r + x / r) / 2
        return int(r)
