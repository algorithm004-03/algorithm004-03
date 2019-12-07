package id_693;

import java.util.Arrays;

/**
 * @Desc 455. 分发饼干   https://leetcode-cn.com/problems/assign-cookies/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/02
 */
public class LeetCode_455_693 {
    // g  胃口最低值
    // s  饼干能量值

    //暴力解法，效率很低 ：执行用时 : 164 ms , 在所有 java 提交中击败了 5.04% 的用户  内存消耗 : 39.9 MB , 在所有 java 提交中击败了 94.85% 的用户
    //时间复杂度是O(MN)   空间复杂度O(N)
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        boolean[] used = new boolean[g.length];
        for (int i = 0; i < s.length; i++) {
            int si = s[i];
            for (int j = 0; j < g.length; j++) {
                int gj = g[j];
                if (si >= gj && !used[j]) {
                    used[j] = true;
                    max++;
                    break;
                }
            }
        }
        return max;
    }

    //贪心计数把。这样时间复杂度O（N) 空间复杂度o(1)
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                max++;
                gi++;
                si++;
            } else {
                si++;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_455_693().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(new LeetCode_455_693().findContentChildren2(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}
