from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        """
        方法？ dp
        ① 起点 跳过
        ② 最左侧 只能向下叠加
        ③ 最上侧 只能向右叠加
        ④ 其他 取小叠加
        """
        # 排
        for x in range(len(grid[0])):
            # 列
            for y in range(len(grid)):
                if not (x or y):
                    continue
                # 最上侧
                elif not x:
                    grid[y][0] += grid[y - 1][0]
                # 最左侧
                elif not y:
                    grid[0][x] += grid[0][x - 1]
                else:
                    grid[y][x] += min(grid[y - 1][x], grid[y][x - 1])

        return grid[-1][-1]


s = Solution()
print(s.minPathSum([[1, 2, 5], [3, 2, 1]]))
print(s.minPathSum([[7, 2], [6, 6], [8, 6], [8, 7], [5, 0], [6, 0]]))
