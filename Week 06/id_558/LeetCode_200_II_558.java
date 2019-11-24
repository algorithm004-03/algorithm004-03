package Week05;

/**
 * @see <a href="547">https://leetcode-cn.com/problems/number-of-islands</a>
 * 岛屿数量
 */
public class LeetCode_200_II_558 {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public void union(int i, int j, int dx, int dy, int row, int col, char[][] M, UnionFind unionFind) {
        if (dx < 0 || dx >= row || dy < 0 || dy >= col || M[dx][dy] == '0') return;
        unionFind.union(i * col + j, dx * col + dy);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        union(i, j, i + dx[k], j + dy[k], row, col, grid, unionFind);
                    }
                }
            }
        }
        return unionFind.getCount();
    }


    static class UnionFind {
        private int[] roots;
        private int[] rank;
        private int count;

        public UnionFind(char[][] M) {
            int row = M.length;
            int col = M[0].length;
            roots = new int[row * col];
            rank = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (M[i][j] == '1') {
                        roots[i * col + j] = i * col + j;
                        count++;
                    }
                }
            }
        }

        public int find(int i) {
            if (roots[i] != i) roots[i] = find(roots[i]);
            return roots[i];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    roots[rootQ] = rootP;
                } else if (rank[rootQ] > rank[rootP]) {
                    roots[rootP] = rootQ;
                } else {
                    roots[rootQ] = rootP;
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

}
