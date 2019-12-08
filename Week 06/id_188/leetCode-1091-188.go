//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索

//leetcode submit region begin(Prohibit modification and deletion)
func shortestPathBinaryMatrix(grid [][]int) int {
	dirs := [][]int{{-1, 0}, {-1, 1}, {0, 1}, {1, 1},
		{1, 0}, {1, -1}, {0, -1}, {-1, -1}}
	R := len(grid)
	C := len(grid[0])
	visited := make([][]bool, 0) // 是否遍历过
	for range make([]int, R) {   // 初始化空的 visited 二维数组
		visited = append(visited, make([]bool, C))
	}
	dis := make([][]int, 0) // 到每个顶点的最短路径长度
	for range make([]int, R) {
		dis = append(dis, make([]int, C))
	}

	if grid[0][0] == 1 { // 起始点阻塞
		return -1
	}
	if R == 1 && C == 1 {
		return 1
	}

	//BFS
	var queue []int          // 申请一个队列
	queue = append(queue, 0) // 队列添加起始点0
	visited[0][0] = true     // 起始点已经遍历过了
	dis[0][0] = 1            // 起始点记录
	for len(queue) > 0 {     // 只要队列不为空就继续执行循环
		cur := queue[0]            // 取出队首元素顶点
		queue = queue[1:]          // 移除队首元素顶点
		curx, cury := cur/C, cur%C // 一维坐标转二维坐标
		for d := 0; d < 8; d++ {   // 查看顶点周围8个方向的相邻顶点
			nextx := curx + dirs[d][0] // 周围8个方向坐标差值
			nexty := cury + dirs[d][1] // 相邻顶点坐标(nextx, nexty)
			//  合法  && 没有被访问过 && 没有被阻塞
			if inArea(nextx, nexty, R, C) && !visited[nextx][nexty] && grid[nextx][nexty] == 0 {
				queue = append(queue, nextx*C+nexty)    // 二维坐标转一维坐标入队
				visited[nextx][nexty] = true            // 记录这个顶点已经被访问过
				dis[nextx][nexty] = dis[curx][cury] + 1 // 到该顶点的路径是从cur顶点+1

				if nextx == R-1 && nexty == C-1 { // 如果(nextx,nexty)是终点
					return dis[nextx][nexty] // 返回到该顶点的距离
				}
			}
		}
	}
	return -1
}

func inArea(x, y, R, C int) bool {
	return x >= 0 && x < R && y >= 0 && y < C
}

//leetcode submit region end(Prohibit modification and deletion)
