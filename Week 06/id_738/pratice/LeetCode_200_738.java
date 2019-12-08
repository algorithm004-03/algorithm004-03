public class Solution {
    // 岛屿数量：https://leetcode-cn.com/problems/number-of-islands/submissions/

    class UnionFind{
        private int[] parent;
        // 并查集有多少个组
        private int group = 0;
        UnionFind(int count) {
            //最后一个元素为特殊元素，所有水都是和他属于同个组
            parent = new int[count + 1];
            group = count + 1;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }
        int find(int i) {
            int root = parent[i];
            while (root != parent[root]) {
                root = parent[root];
            }
            // 路径压缩
            while (i != parent[i]) {
                int tmp = parent[i];
                parent[i] = root;
                i = tmp;
            }
            return root;
        }
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
                group --;
            }
        }
        int countGroup() {
            return group;
        }
    }

    int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int di = 0; di < 4; di ++) {
                        int new_i = i + dy[di];
                        int new_j = j + dx[di];
                        if (0 <= new_i && new_i < m && 0 <= new_j && new_j < n && grid[new_i][new_j] == '1') {
                            uf.union(i * n + j, new_i * n + new_j);
                        }
                    }
                } else {
                    uf.union(i * n + j, m * n);
                }
            }
        }
        // 并查集有多少个组就是多少个岛屿
        return uf.countGroup() - 1;
    }
}