package Week03;

import java.util.Arrays;

/**
 * @Date 2019/11/1.
 * @see <a href="455">https://leetcode-cn.com/problems/assign-cookies/description/</a>
 * 分发饼干
 */
public class LeetCode_455_558 {
    /**
     * 步骤：
     * 1、先排序
     * 2、遍历
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                ret++;
            } else {
                j++;
            }
        }
        return ret;
    }
}
