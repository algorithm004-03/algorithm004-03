package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 * @Date 2019/11/21
 */
public class LeetCode_200_693 {
    // dfs
    // 并查集

    class Solution {
        int count;//计数
        int[] parent;//数据存储
        int[] rank;//层数
        int[] xlist = {1,-1,0,0};
        int[] ylist = {0,0,1,-1};

        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            unionBuild(grid);
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0';
                        for (int k = 0; k < 4; k++) {
                            int a = xlist[k] + i;
                            int b = ylist[k] + j;
                            if (a >= 0 && b >= 0 && a < m && b < n && grid[a][b] == '1') {
                                union(i * n + j,a * n + b);
                            }
                        }
                    }
                }
            }
            return count;
        }

        private void unionBuild(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        private int find(int i) {
            int root = i;
            while (parent[i] != i) {
                i = parent[i];
            }
            //路径压缩 （这种压缩方案比下面的那种更优）
            while (root != i) {
                int t = parent[root];
                parent[root] = i;
                root = t;
            }
            return i;
        }

        private void union(int i,int j) {
            int iSet = find(i);
            int jSet = find(j);
            if (iSet != jSet) {
                //使用rank进行路径压缩，没有上面的那种好，
                if (rank[iSet] > rank[jSet]) {
                    parent[jSet] = iSet;
                } else if (rank[iSet] < rank[jSet]) {
                    parent[iSet] = jSet;
                } else {
                    parent[iSet] = jSet;
                    rank[jSet] += 1;
                }
                --count;
            }
        }
    }
}
