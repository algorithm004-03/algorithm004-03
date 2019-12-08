from typing import List


class Solution:
	def search(self, nums: List[int], target: int) -> int:
		"""
		先写 left, right = 1 ,length - 1
		循环： 如果 右边 》= left 就不停
		middle = left + (right - left) // 2 防止left 和 right 都和大 溢出
		因为旋转，所以通过中间值判断那面有序
		判断在左，右边变为中
		判断在右，左边变为中
		"""
		left, right = 0, len(nums) - 1
		while left <= right:
			middle = left + (right - left) // 2
			if nums[middle] == target:
				return middle
			# 左边有序
			if nums[left] <= nums[middle]:
				# 判断在左，右边变为中
				if nums[left] <= target < nums[middle]:
					right = middle - 1
				# 判断在右，左边变为中
				else:
					left = middle + 1
			# 右边有序
			elif nums[middle] <= nums[right]:
				# 判断在右，左边变为中
				if nums[middle] < target <= nums[right]:
					left = middle + 1
				# 判断在左，右边变为中
				else:
					right = middle - 1
		return -1
