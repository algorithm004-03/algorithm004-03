class Solution:
    # 暴力搜索
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for row in matrix:
            for i in row:
                if target == i:
                    return True

        return False

    # 降维检索
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        temp = []
        for l in matrix:
            temp.extend(l)

        left = 0
        right = len(temp) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if temp[mid] == target:
                return True
            elif temp[mid] < target:
                left = mid + 1
            else:
                right = mid -1

        return False

    # 不降维检索：
    # 1.从左下角开始，判断target可能在哪一行
    # 2.在该行中进行二分查找
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False

        m, n = len(matrix), len((matrix[0]))

        while matrix[m - 1][0] > target and m > 1:
            m -= 1

        left, right = 0, n - 1
        while left <= right:
            mid = left + (right - left) // 2
            tmp = matrix[m - 1][mid]
            if tmp == target:
                return True
            elif tmp > target:
                right = mid - 1
            else:
                left = mid + 1
        return False
