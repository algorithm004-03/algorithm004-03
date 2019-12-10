/**
 * @author rongsimin
 * @date 2019/11/2 16:20
 */
public class 岛屿数量200 {
		private int[] dx = new int[]{-1,1,0,0};
		private int[] dy = new int[]{0,0,-1,1};
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
					result += floodfill(i,j);
				}
			}
			return result;
		}

		private int floodfill(int i,int j) {
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
					floodfill(x,y);
				}
			}
			//reverse status if need
			return 1;
		}

	public static void main(String[] args) {
		char[][] chars = new char[4][5];
		chars[0] =new char[]{'1','1','1','1','0'};
		chars[1] =new char[]{'1','1','0','1','0'};
		chars[2] =new char[]{'1','1','0','0','0'};
		chars[3] =new char[]{'0','0','0','0','0'};
		int i = new 岛屿数量200().numIslands(chars);
		System.out.println(i);
	}

}
