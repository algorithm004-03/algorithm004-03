class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        不同路径2：https://leetcode-cn.com/problems/unique-paths-ii/

        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        a = [0] * n
        a[0] = 1
        for row in obstacleGrid:
            for i in range(n):
                if row[i] == 1:
                    a[i] = 0
                elif i > 0:
                    a[i] += a[i - 1]
        return a[-1]
                






