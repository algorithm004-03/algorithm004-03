/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.69%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    35.9K
 * Total Submissions: 78.6K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 *
 */

// @lc code=start
package leetCode

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}
	ret := 0
	for x, _ := range grid {
		if len(grid[x]) == 0 {
			continue
		}
		for y, _ := range grid[x] {
			if grid[x][y] == '1' {
				ret++
				dfs(grid, x, y)
			}
		}
	}
	return ret
}

func dfs(grid [][]byte, x, y int) {
	if grid[x][y] == '0' {
		return
	}
	grid[x][y] = '0'
	if x > 0 {
		dfs(grid, x-1, y)
	}
	if x < len(grid)-1 {
		dfs(grid, x+1, y)
	}
	if y > 0 {
		dfs(grid, x, y-1)
	}
	if y < len(grid[x])-1 {
		dfs(grid, x, y+1)
	}

}

// @lc code=end
