// https://leetcode-cn.com/problems/number-of-islands/

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    if (!grid || !grid.length) return 0;
    var n = grid.length,
        m = grid[0].length,
        union = new UnionFind(grid);
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                if (i - 1 >= 0 && grid[i - 1][j] == 1)
                    union.union(i * m + j, (i - 1) * m + j);
                if (i + 1 < n && grid[i + 1][j] == 1)
                    union.union(i * m + j, (i + 1) * m + j);
                if (j - 1 >= 0 && grid[i][j - 1] == 1)
                    union.union(i * m + j, i * m + (j - 1));
                if (j + 1 < m && grid[i][j + 1] == 1)
                    union.union(i * m + j, i * m + (j + 1));
            }
        }
    }
    return union.count;
};

function UnionFind (grid) {
    this.parent = [];
    this.count = 0;
    this.init(grid);
}

UnionFind.prototype.init = function (grid) {
    var n = grid.length,
        m = grid[0].length;
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                this.parent[i * m + j] = i * m + j;
                this.count++;
            }
        }
    }
    
}

UnionFind.prototype.find = function (i) {
    if (this.parent[i] != i)
        return this.find(this.parent[i])
    return this.parent[i];
}

UnionFind.prototype.union = function (i, j) {
    var rootI = this.find(i);
    var rootJ = this.find(j);
    if (rootI == rootJ) return;
    this.parent[rootJ] = this.parent[rootI];
    this.count--;
}

// var res1 = numIslands([
//     [1, 1, 1],
//     [1, 0, 1],
//     [1, 1, 1]])
// console.log(res1);
var res1 = numIslands([
    [1, 1, 1, 0, 0],
    [1, 1, 0, 1, 0],    
    [1, 1, 0, 1, 0],
    [0, 0, 0, 0, 0]
])
console.log(res1);
// var res1 = numIslands([
//     [1, 1, 0, 0, 0],
//     [1, 1, 0, 0, 0],
//     [0, 0, 1, 0, 0],
//     [0, 0, 0, 1, 1]
// ])
// console.log(res1);