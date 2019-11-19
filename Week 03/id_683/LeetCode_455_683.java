import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length;) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}