//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private int[] dx = new int[]{-1, 1, 0, 0};
	private int[] dy = new int[]{0, 0, -1, 1};
	private char[][] g;

	public int numIslands(char[][] grid) {
		if (grid == null) return -1;
		g = grid;

		int result = 0;
		//对二维数组进行遍历，用沉到办法将1炸成0
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				if (g[i][j] == '0') continue;
				//否则调用函数进行炸岛
				result += floodfill(i, j);
			}
		}
		return result;
	}

	private int floodfill(int i, int j) {
		//terminator
		if (g[i][j] == '0') {
			return 0;
		}
		//process current level logic
		g[i][j] = '0';
		//这里写错，是在坐标轴里对X,Y轴进行平移,我写成g.length了，这个和二维数组没半毛关系
		for (int k = 0; k < dx.length; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < g.length && y >= 0 && y < g[0].length) {
				if (g[x][y] == '0') continue;
				//drill down
				floodfill(x, y);
			}
		}
		//reverse status if need
		return 1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
