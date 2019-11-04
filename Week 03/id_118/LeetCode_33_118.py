# -*- coding: utf-8 -*-
# Created by Isaac Zhou at 11/3/2019
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1

        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if target == nums[mid]:
                return mid

            if nums[l] <= nums[mid]:
                if nums[l] <= target <= nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if nums[mid] <= target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

        return -1
