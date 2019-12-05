package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @Date 2019/12/05
 */
public class LeetCode_5_693 {
    /**
     * 中心扩展法 采用字符串
     */
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String res1 = longestPalindrome(s,i,i);
                String res2 = longestPalindrome(s,i,i + 1);
                String max = res1.length() > res2.length() ? res1 : res2;
                if (max.length() > res.length()) {
                    res = max;
                }
            }
            return res;
        }

        private String longestPalindrome(String s,int i,int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            return s.substring(i + 1,j);
        }
    }

    /**
     * 动态规划     和647. 回文子串	https://leetcode-cn.com/problems/palindromic-substrings 一摸一样，只是用2个指针获得最大值而已
     * .    dp方程： dp[j][i] = (s[i]==s[j] && (i-j==1 || dp[j+1][i-1])) ? true : false
     * .    动态规划更新双指针：i - j > end - start;
     */
    class Solution2 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len == 0) return "";
            int start = 0;
            int end = 0;
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j || (s.charAt(i) == s.charAt(j) && (i - j == 1 || dp[j + 1][i - 1]))) {
                        dp[j][i] = true;
                        if (i - j > end - start) {
                            end = i;
                            start = j;
                        }
                    }
                }
            }
            return s.substring(start,end + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_5_693().new Solution().longestPalindrome("babad"));
        System.out.println(new LeetCode_5_693().new Solution().longestPalindrome("abbs"));
    }
}
