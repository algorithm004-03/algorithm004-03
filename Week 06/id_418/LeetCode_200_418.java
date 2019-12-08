package com.ljg.leetcode.week06.a03;

/**
 * NumberOfIslands
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands nIslands = new NumberOfIslands();
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int num = nIslands.numIslands(grid);
        System.out.println("num:" + num);
    }

    int row;
    int col;

    private class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int getIndex(int i, int j) {
            return i * col + j;
        }

        int getCount() {
            return count;
        }

        int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI == rootJ) {
                return;
            }

            if (rootI < rootJ) {
                parent[j] = rootI;
            } else {
                parent[i] = rootJ;
            }

            count--;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || (grid.length == 0 && grid[0].length == 0)) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;

        UnionFind unionFind = new UnionFind(row * col);

        int waters = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    waters++;
                    continue;
                }

                if ((j + 1) < col && grid[i][j + 1] == '1') {
                    int index1 = unionFind.getIndex(i, j);
                    int index2 = unionFind.getIndex(i, j + 1);
                    unionFind.union(index1, index2);
                }

                if ((i + 1) < row && grid[i + 1][j] == '1') {
                    int index1 = unionFind.getIndex(i, j);
                    int index2 = unionFind.getIndex(i + 1, j);
                    unionFind.union(index1, index2);
                }

            }
        }

        return unionFind.getCount() - waters;

    }
}