package com.hand.week6;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/24
 */
public class LeetCode_200_578 {
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') uf.union(node(i, j), dummyNode);
                else {
                    if (i + 1 < rows && grid[i + 1][j] == '1') uf.union(node(i + 1, j), node(i, j));
                    if (j + 1 < cols && grid[i][j + 1] == '1') uf.union(node(i, j + 1), node(i, j));
                }
            }
        }
        return uf.getCount() - 1;
    }

    public int node(int i, int j) {
        return cols * i + j;
    }

    class UnionFind {
        private int[] parents;
        private int count;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            count = totalNodes;
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parents[rootQ] = rootP;
            count--;
        }

        public int find(int p) {
            if (p == parents[p])
                return p;
            parents[p] = find(parents[p]);
            return parents[p];
        }

        public int getCount() {
            return count;
        }
    }
}
