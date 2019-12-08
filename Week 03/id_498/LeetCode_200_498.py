from typing import List


class Solution:
	def numIslands(self, grid: List[List[str]]) -> int:
		"""
		DFS
		"""
		# 计数
		count = 0
		row = len(grid)
		if not row:
			return 0
		col = len(grid[0])

		def dfs(r_i, c_i):
			if grid[r_i][c_i] == '0':
				return
			# 标记为 0
			# visited.add(node)
			grid[r_i][c_i] = '0'
			# 查找四周
			# for next_node in node.children():
			for x, y in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
				tmp_r_i = r_i + x
				tmp_c_i = c_i + y
				# 不能超出地图
				# if not next_node in visited
				if 0 <= tmp_r_i < row and 0 <= tmp_c_i < col and grid[tmp_r_i][tmp_c_i] == '1':
					# 再向四周找
					# def dfs(next_node, visited)
					dfs(tmp_r_i, tmp_c_i)

		for row_ids in range(row):
			for col_ids in range(col):
				# 如果是 1 代表是陆地
				if grid[row_ids][col_ids] == '1':
					# 查看四周，看陆地有多大
					dfs(row_ids, col_ids)
					# 发现一个陆地
					count += 1

		return count


s = Solution()
print(s.numIslands(
	[["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"], ["0", "0", "0", "0", "0"]]))
