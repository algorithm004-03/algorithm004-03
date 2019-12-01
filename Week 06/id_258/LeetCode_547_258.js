/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 朋友圈
 */

// @lc code=start
/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function (M) {
    if (M.length == 0 || M == null) return 0;

    let p = [];
    let N = M.length;

    function union(x, y) {
        p[findParent(x)] = findParent(y)
    }

    function findParent(node) {
        if (p[node] == node) return node;

        while (p[node] != node) {
            node = p[node];
        }

        return p[node];
    }

    for (let i = 0; i < N; i++) {
        p[i] = i;
    }

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (M[i][j] == 1) {
                union(i, j);
            }
        }
    }

    let s = new Set();

    for (let i = 0; i < N; i++) {
        s.add(findParent(p[i]))
    }

    return s.size;
};
// @lc code=end