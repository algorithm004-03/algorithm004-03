from typing import List


class Solution:
	def findMin(self, nums: List[int]) -> int:
		"""

		"""
		left, right = 0, len(nums) - 1
		while left < right:
			middle = left + (right - left) // 2
			if nums[middle] > nums[right]:
				left = middle + 1
			else:
				right = middle
		return nums[left]
