/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r++])
                l++;
        }
        return l;
    }
}
// @lc code=end
