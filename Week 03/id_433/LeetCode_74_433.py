class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False

        m = len(matrix)
        n = len(matrix[0])

        left = 0
        right = m*n-1
        while left <= right:
            mid = (left + right)//2
            mid_ele = matrix[mid//n][mid % n]
            if mid_ele == target:
                return True
            elif mid_ele < target:
                left = mid+1
            else:
                right = mid-1
        return False