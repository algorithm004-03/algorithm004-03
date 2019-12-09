/*
 * @lc app=leetcode.cn id=62 lang=golang
 *
 * [62] 不同路径
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (56.91%)
 * Likes:    351
 * Dislikes: 0
 * Total Accepted:    51.2K
 * Total Submissions: 89.5K
 * Testcase Example:  '3\n2'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 *
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 */

// @lc code=start
func uniquePaths(m int, n int) int {
	// 二维数组
	// griph := [][]int{}
	// for i := 0; i < m; i++ {
	// 	griph = append(griph, make([]int, n, n))
	// 	griph[i][0] = 1
	// }
	// for i := 0; i < n; i++ {
	// 	griph[0][i] = 1
	// }
	// for i := 1; i < m; i++ {
	// 	for j := 1; j < n; j++ {
	// 		griph[i][j] = griph[i-1][j] + griph[i][j-1]
	// 	}
	// }
	// return griph[m-1][n-1]

	// 一维数组
	cache := make([]int, n, n)
	for index := 0; index < n; index++ {
		cache[index] = 1
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			cache[j] += cache[j-1]
		}
	}
	return cache[n-1]
}

// @lc code=end
