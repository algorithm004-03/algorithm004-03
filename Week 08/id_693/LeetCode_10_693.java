package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 10. 正则表达式匹配 https://leetcode-cn.com/problems/regular-expression-matching/
 * @Date 2019/12/06
 */
public class LeetCode_10_693 {
    /**
     * 规律字符p是否包含字符s
     * 回溯：思路：
     * 。        1、判断是否相等 且 源字符不能为null
     * 。          2、存在   * ，判断长度是否大于等于2  且索引 1 等于 *
     * 。                 枚举如下两种情况
     * 。                 a、符合条件1，且枚举源字符 进 1 的结果，都是true 为true
     * 。                 b、直接考虑 * 匹配零个前字符，所以直接移动规律字符索引 进 2 (c*  如果匹配0 就是"")
     * 。          3、第二位 不存在 * ，则直接进入 下一步，且都移动源字符和规律字符索引 1
     */
    class Solution {
        public boolean isMatch(String s,String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean firstMath = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return firstMath && isMatch(s.substring(1),p)//匹配一个或多个
                        || isMatch(s,p.substring(2));//匹配0个
            }
            return firstMath && isMatch(s.substring(1),p.substring(1));
        }
    }

    /**
     * 动态规划  top-down
     */
    class Solution2 {
        public boolean isMatch(String s,String p) {
            int sLen = s.length();
            int pLen = p.length();
            boolean[][] dp = new boolean[sLen + 1][pLen + 1];
            dp[0][0] = true;
            for (int i = 0; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (p.charAt(j - 1) == '*') {
                        boolean firstMath = i > 0 &&
                                (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                        dp[i][j] = (firstMath && dp[i - 1][j]) || dp[i][j - 2];
                    } else {
                        boolean firstMath = i > 0 &&
                                (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                        dp[i][j] = firstMath && dp[i - 1][j - 1];
                    }
                }
            }
            return dp[sLen][pLen];
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("aa","a*"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("abc","abc"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("abc","a.c"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("abc","ab*c"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("abcccde","abc*de"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("aaaa","a*a"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("aaaac","a*a"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("asadfasfaaa",".*"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("ab",".*c"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("abcdsaas","e*abcdsaas"));
        System.out.println(new LeetCode_10_693().new Solution2().isMatch("abcdsaas","esabcdsaas"));
    }
}
