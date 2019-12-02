import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(child < g.length && cookie<s.length){
            if(g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}
// @lc code=end

