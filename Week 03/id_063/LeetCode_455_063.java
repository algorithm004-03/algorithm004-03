/*

贪心策略，每个饼干都发挥最大功效即可
 */

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);

        int cnt = 0;
        for (int i = g.length-1, j = s.length - 1; (i >= 0) && (j >= 0); ) {
            if (g[i] <= s[j]) {
                i--; j--; cnt++;
            } else {
                i--;
            }
        }

        return cnt;
    }
}