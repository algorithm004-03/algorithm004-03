import java.util.Arrays;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
public class LeetCode_200_593 {
    private final static int[] DX = new int[]{-1, 1, 0, 0};
    private final static int[] DY = new int[]{0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + DX[k];
                        int y = j + DY[k];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            System.out.println(x * col + y + 1);
                            unionFind.union(i * col + j, x * col + y);
                        }
                    }
                }
            }
        }
        return unionFind.count;
    }

    static class UnionFind {
        private int count = 0;
        private int[] parent;

        public int[] getParent() {
            return parent;
        }

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        parent[i * col + j] = i * col + j;
                    }
                }
            }
            System.out.println(Arrays.toString(parent));
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            parent[qRoot] = pRoot;
            count--;
        }


    }
}
