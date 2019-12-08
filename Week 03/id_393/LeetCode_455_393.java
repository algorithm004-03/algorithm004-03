package no455;

import java.util.Arrays;

/**
 * @author boyiren
 * @date 2019-11-03
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r++]) l++;
        }
        return l;
    }
}
