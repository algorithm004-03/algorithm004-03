package com.hand.week6;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/24
 */
public class LeetCode_130_578 {
    int rows;
    int cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        rows = board.length;
        cols = board[0].length;
        //多申请一个空间
        UnionFind uf = new UnionFind(rows * cols + 1);
        //所有边界的O节点都和dummy节点合并
        int dummyNode = rows * cols;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] != 'O') continue;
                //当前节点在边界就和dummy合并
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) uf.union(node(i, j), dummyNode);
                else {
                    //将上下左右的O节点和当前节点合并
                    if (board[i - 1][j] == 'O') uf.union(node(i, j), node(i - 1, j));
                    if (board[i + 1][j] == 'O') uf.union(node(i, j), node(i + 1, j));
                    if (board[i][j - 1] == 'O') uf.union(node(i, j), node(i, j - 1));
                    if (board[i][j + 1] == 'O') uf.union(node(i, j), node(i, j + 1));
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                //判断是否和dummy节点是一类
                if (uf.isConnected(dummyNode, node(i, j))) board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public int node(int i, int j) {
        return cols * i + j;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parents[rootQ] = rootP;
            }
        }

        public int find(int p) {
            if (p == parents[p])
                return p;
            parents[p] = find(parents[p]);
            return parents[p];
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
