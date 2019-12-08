import java.util.Arrays;

/**
 * 分饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class LeetCode_455_588 {

    public int findContentChildren(int[] g, int[] s) {
        if (null == g || null == s) {
            return 0;
        }

        // 排序
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i ++;
            }
            j ++;
        }

        return i;
    }

    public static void main(String[] args) {

        LeetCode_455_588 solution = new LeetCode_455_588();
        System.out.println(solution.findContentChildren(new int[]{2, 3, 1}, new int[]{1, 1, 2}));
        System.out.println(solution.findContentChildren(new int[]{2, 3, 2}, new int[]{1, 1, 1}));
        System.out.println(solution.findContentChildren(new int[]{2, 3, 4}, new int[]{1, 3, 4, 5}));

    }
}
