// https://leetcode-cn.com/problems/friend-circles/

/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function (M) {
    if (!M || !M.length) return 0;
    var n = M.length,
        parent = [],
        count = n;
    for (i = 0; i < n; i++) 
        parent[i] = i;
    for (var i = 0; i < n; i++) {
        for (var j = i; j < n; j++) {
           if (i !== j && M[i][j] === 1)
            unio(i, j);
        }
    }
    return count;
    function unio(i, j) {
        var rootI = find(i);
        var rootJ = find(j);
        if (rootI === rootJ) return;
        if (rootI < rootJ)
            parent[rootJ] = rootI;
        else
            parent[rootI] = rootJ;
        count--; 
    }
    function find(i) {
        if (parent[i] !== i) 
            return find(parent[i]);
        return parent[i];
    }
};


var res1 = findCircleNum([
    [1, 0, 0, 1],
    [0, 1, 1, 0],
    [0, 1, 1, 1],
    [1, 0, 1, 1]])
console.log(res1);
var res1 = findCircleNum([
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]
])
console.log(res1);
var res1 = findCircleNum([
    [1, 1, 0],
    [1, 1, 1],
    [0, 1, 1]
])
console.log(res1);