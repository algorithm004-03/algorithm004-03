/*
 * @lc app=leetcode.cn id=63 lang=golang
 *
 * [63] 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (31.78%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    28.9K
 * Total Submissions: 90.8K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 *
 */

// @lc code=start
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if obstacleGrid == nil || len(obstacleGrid) == 0 {
		return 0
	}
	r, c := len(obstacleGrid), len(obstacleGrid[0])
	if obstacleGrid[r-1][c-1] == 1 {
		return 0
	}
	cache := [][]int{}
	for i := 0; i < r; i++ {
		cache = append(cache, make([]int, c, c))
	}
	cache[r-1][c-1] = 1
	for i := r - 2; i >= 0; i++ {
		if obstacleGrid[i][c-1] != 1 {
			cache[i][c-1] = cache[i+1][c-1]
		}
	}
	for i := c - 2; i >= 0; i++ {
		if obstacleGrid[r-1][i] != 1 {
			cache[r-1][i] = cache[r-1][i+1]
		}
	}
	for i := r - 2; i >= 0; i-- {
		for j := c - 2; j >= 0; j-- {
			if obstacleGrid[i][j] != 1 {
				cache[i][j] = cache[i+1][j] + cache[i][j+1]
			}
		}
	}

	return cache[0][0]
}

// @lc code=end
