from typing import List


class Solution:
    @staticmethod
    def maximalRectangle(matrix: List[List[str]]) -> int:
        """
        方法：dp
        """
        # 特判
        if not matrix:
            return 0

        # 初始化
        rows = len(matrix)
        columns = len(matrix[0])
        # 下标是 0 开始
        left = [-1] * columns
        # 下标是 columns - 1 结束
        right = [columns] * columns
        height = [0] * columns
        maxArea = 0

        # 两层循环
        for y in range(rows):
            current_left = -1
            current_right = columns

            # 更新高
            for x in range(columns):
                # 如果碰到 1 了
                if matrix[y][x] == '1':
                    # 高度就累加 1
                    height[x] += 1
                else:
                    # 没有就是 0
                    height[x] = 0

            # 更新左指针
            for x in range(columns):
                # 如果碰到了 1
                if matrix[y][x] == '1':
                    # 对比下标，谁更靠右
                    left[x] = max(left[x], current_left)
                # 如果是 0
                else:
                    left[x] = -1
                    # 记录当前下标
                    current_left = x

            # 更新右指针
            for x in range(columns - 1, -1, -1):
                # 如果碰到了 1
                if matrix[y][x] == '1':
                    # 对比下标，谁更靠左
                    right[x] = min(right[x], current_right)
                # 如果是 0
                else:
                    right[x] = columns
                    # 记录当前下标
                    current_right = x

            # 更新面积
            for x in range(columns):
                maxArea = max(maxArea, height[x] * (right[x] - left[x] - 1))

        return maxArea


m = [
    ["1", "0", "1", "0", "0"],
    ["1", "0", "1", "1", "1"],
    ["1", "1", "1", "1", "1"],
    ["1", "0", "0", "1", "0"]
]

s = Solution.maximalRectangle(m)
print(s)
