from typing import List


class Solution1:
    """
    solution with 2 pointers
    the amount of water will always be
    the difference between the max height and current height, otherwise water will spill
    Time Complexity: O(n)
    """

    def trap(self, height: List[int]) -> int:
        # Initialize left and right pointer
        left, right = 0, len(height) - 1
        # Initialize left max, right max and water
        l_max, r_max, water = 0, 0, 0
        # keep looping as long as two pointers don't meet
        while left <= right:
            if l_max <= r_max:
                # on the left side
                # if the current height is no greater than left max, store water
                # otherwise water will spill
                # if the current height is greater than left max
                # swap left max and height, move to the next iteration
                if l_max >= height[left]:
                    water += l_max - height[left]
                else:
                    l_max = height[left]
                left += 1
            else:
                # same on the right
                if r_max >= height[right]:
                    water += r_max - height[right]
                else:
                    r_max = height[right]
                right -= 1
        return water


class Solution2:
    """
    Solve the problem with 'dynamic programming'
    Not sure if it's truly DP, but use two hash tables to store the
    calculated results in the caches
    """

    def trap(self, height: List[int]) -> int:
        # create two hash tables lmax and rmax to store the max val
        res, lmax, rmax = 0, {}, {}
        if len(height) == 0:
            return res

        lmax[0] = height[0]
        for left in range(1, len(height)):
            lmax[left] = max(lmax[left-1], height[left])

        rmax[len(height)-1] = height[-1]
        for right in range(len(height)-2, -1, -1):
            rmax[right] = max(rmax[right+1], height[right])

        for i in range(len(height)):
            res += (min(lmax[i], rmax[i]) - height[i])

        return res


if __name__ == '__main__':
    sol1 = Solution1()
    l = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print(sol1.trap(l))

    sol2 = Solution2()
    print(sol2.trap(l))
