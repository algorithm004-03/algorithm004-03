/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * @author L
 *
 */
public class LeetCode_200_138 {
	public int numIslands(char[][]grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		int nr = grid.length;//行的长度
		int nc = grid[0].length;//列的长度
		int count = 0;
		for(int r=0;r<nr;++r) {
			for(int c=0;c<nc;++c) {
				if(grid[r][c] == '1') {
					++count;
					dfs(grid,r,c,nr,nc);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int r, int c,int nr,int nc) {
		if(r<0 || c<0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		dfs(grid,r-1,c,nr,nc);//向上搜索
		dfs(grid,r+1,c,nr,nc);//向下搜索
		dfs(grid,r,c-1,nr,nc);//向左
		dfs(grid,r,c+1,nr,nc);//向右
	}
}
