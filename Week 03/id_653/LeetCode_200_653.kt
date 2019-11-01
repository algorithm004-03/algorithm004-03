class Solution {

    fun dfs(grid: Array<CharArray>, index: Int, k: Int): Int {
        grid?.let {
            var nr = it.size
            var nc = it[0].size
            if (index < 0 || k < 0 || index >=nr || k >=nc || it[index][k].equals('0')) {
                return 0
            }
            it[index][k] = '0'
            dfs(grid, index + 1, k)
            dfs(grid, index - 1, k)
            dfs(grid, index, k + 1)
            dfs(grid, index, k - 1)

            return 1
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()||grid==null) {
            return 0
        }

        grid?.filter { grid.isNotEmpty()}.let {
            var nr = it.size
            var nc = it[0].size
            var sum = 0;
            for (index in grid.indices) {
                var array = grid[index]
                for (k in array.indices) {
                    var item = array[k]
                    if (item.equals('1')) {
                        var res = dfs(grid, index, k)
                        sum += res
                    }
                }
            }
            return sum
        }

        return 0
    }
}