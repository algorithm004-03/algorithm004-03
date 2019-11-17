/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    var result = 0;

    while (1) {
        var island = hasIsland();

        if (!~island[0]) {
            break;
        }

        dropIsland(island[0], island[1]);
        ++result;
    }

    return result;

    function hasIsland(){
        for (var i = 0; i < grid.length; ++i) {
            for (var j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] === "1") {
                    return [i, j];
                }
            }
        }

        return [-1, -1];
    }

    function dropIsland(i, j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] === "0") {
            return false;
        }

        grid[i][j] = "0";
        dropIsland(i + 1, j);
        dropIsland(i - 1, j);
        dropIsland(i, j + 1);
        dropIsland(i, j - 1);
    }
};
