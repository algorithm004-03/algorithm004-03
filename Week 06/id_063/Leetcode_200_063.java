/*
构建并查集， 遍历每一个1节点，检查每个1节点下面和右边的节点是不是1，
若是1，则将本节点和下面或者右边的节点并在一个集合中，每并一个新节点
集合个数减去一个，每发现一个数值为1的新节点，集合数量加上一个，返回
最后集合个数
*/


class UnionSet {
    private int len;
    private int[] buf;

    UnionSet(int len, char[][] grid) {
        this.len = len;
        buf = new int[len];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    int index = i * grid[0].length + j;
                    buf[index] = index;
                }
            }
        }
    }

    private int findRoot(int n) {
        int node;

        node = n;
        while (buf[node] != node) {
            node = buf[node];
        }

        int root = node;

        // 路径压缩
        node = n;
        while (buf[node] != node) {
            int tmp = buf[node];
            buf[node] = root;
            node = tmp;
        }

        return root;
    }

    public boolean merge(int p, int q) {
        int root_p = findRoot(p);
        int root_q = findRoot(q);

        if (root_p != root_q) {
            buf[root_p] = root_q;
            return true;
        }

        return false;
    }

}

class Solution {
    public int numIslands(char[][] grid) {
        if ((grid == null) || (grid.length == 0)) {
            return 0;
        }

        if (grid[0].length == 0) {
            return 0;
        }

        UnionSet us = new UnionSet(grid.length * grid[0].length, grid);

        int unionCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                unionCnt++;

                if ((i+1 < grid.length) && (grid[i+1][j] == '1')) {
                    if (us.merge( (i+1)*grid[0].length + j, i*grid[0].length + j )) {
                        unionCnt--;
                    }
                }

                if ( (j+1 < grid[0].length) && (grid[i][j+1] == '1') ) {
                    if (us.merge( i*grid[0].length + j, i*grid[0].length + j+1 )) {
                        unionCnt--;
                    }
                }
            }
        }

        return unionCnt;
    }

    public static void main(String[] args) {
        new Solution().numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            }
        );
    }
}