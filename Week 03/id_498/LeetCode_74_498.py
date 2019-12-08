from typing import *


class Solution:
	def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
		"""
		row = middle // n ， col = middle % n
		matrix[row][col]
		"""
		if m := len(matrix) == 0:
			return False
		n = len(matrix[0])
		left, right = 0, m * n - 1
		while left <= right:
			middle = left + (right - left) // 2
			# 求中间值要转换一下
			middle_matrix = matrix[middle // n][middle % n]
			if middle_matrix == target:
				return True
			else:
				if target < middle_matrix:
					right = middle - 1
				else:
					left = middle + 1
		return False
