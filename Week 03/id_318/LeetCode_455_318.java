/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] grid, int[] size) {
        if(grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int g = 0, s = 0;
        while(g < grid.length && s < size.length) {
            if(grid[g] <= size[s++]) g++;
        }
        return g;
    }
}
// @lc code=end

