from typing import List


class Solution:
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
