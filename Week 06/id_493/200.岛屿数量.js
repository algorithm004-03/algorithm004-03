/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    class UnionFind {
       constructor(testGrid) {
            this.count = 0;
            this.parent = [];
            let wlen = testGrid.length;
            let hlen = testGrid[0].length;
            for (let i = 0; i < wlen; i++) {
                for (let j = 0; j < hlen; j++) {
                    if (testGrid[i][j] == 1) {
                        this.parent[i * hlen + j] = i * hlen + j;
                        this.count = this.count + 1;
                    } else {
                        this.parent[i * hlen + j] = -1;
                    }
                }
            }
       }
       find(n) {
           while (this.parent[n] != n && this.parent[n] != -1) {
               n = this.parent[n];
           }
           return this.parent[n];
       }
       union(p, q) {
           let pRoot = this.find(p);
           let qRoot = this.find(q);
           if (pRoot == -1 || qRoot == -1 || pRoot == qRoot) {
               return;
           }
           this.parent[qRoot] = pRoot;
           this.count = this.count - 1;
       }
    }

    if (grid.length == 0) {
        return 0;
    }

    let uf = new UnionFind(grid);
    let wlen = grid.length;
    let hlen = grid[0].length;
    for (let i = 0; i < wlen; i++) {
        for (let j = 0; j < hlen; j++) {
            if (grid[i][j] == 1) {
                if (i > 0 && grid[i - 1][j] == 1) {
                    uf.union((i - 1) * hlen + j, i * hlen + j);
                }
                if (i < wlen - 1 && grid[i + 1][j] == 1) {
                    uf.union((i + 1) * hlen + j, i * hlen + j);
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    uf.union(i * hlen + j - 1, i * hlen + j);
                }
                if (j < hlen - 1 && grid[i][j + 1] == 1) {
                    uf.union(i * hlen + j + 1, i * hlen + j);
                }
            }
        }
    }
    return uf.count;
};
// @lc code=end

