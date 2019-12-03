/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
    var n = M.length;

    if (n === 0) {
        return 0;
    }

    var count = 0;

    function bfs(i){
        var queue = [i];

        while (queue.length) {
            var p = queue.pop();

            for (var j = 0; j < n; ++j){
                if (M[p][j] === 1 && !visited[j]) {
                    visited[j] = true;
                    queue.push(j);
                }
            }
        }
    }

    var visited = {};

    for(var i = 0; i < n; ++i){
        if (!visited[i]) {
            bfs(i);
            ++count;
        }
    }

    return count;
};
