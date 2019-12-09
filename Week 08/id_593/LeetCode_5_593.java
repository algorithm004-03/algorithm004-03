/**
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 链接：https://leetcode.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思考：
 * <p> a[l][r] / true 是回文子串
 * <p>         \ false 不是回文字串
 * <p> a[l][r] = a[l+1][r-1] && a[l] == a[r]
 *
 * @author jaryoung
 * @version 1.0
 */
public class LeetCode_5_593 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] a = new boolean[length][length];
        String longestPalindromicSubstring = s.substring(0, 1);
        int longestPalindromicSubstringLength = 1;
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                a[l][r] = s.charAt(l) == s.charAt(r) && (r - l <= 2 || a[l + 1][r - 1]);
                if (a[l][r]) {
                    int checkLength = r - l + 1;
                    if (checkLength > longestPalindromicSubstringLength) {
                        longestPalindromicSubstringLength = checkLength;
                        longestPalindromicSubstring = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromicSubstring;
    }
}
