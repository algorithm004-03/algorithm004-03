package id_693;

/**
 * @Desc 647. 回文子串	https://leetcode-cn.com/problems/palindromic-substrings/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/17
 */
public class LeetCode_647_693 {
    // 中心扩散
    public int countSubstrings2(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            //以自己为中心扩散
            result += countSubstrings(s, i, i);
            //如果和下一个char相同，进行扩散
//          if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {result += countSubstrings(s, i, i + 1);}
            result += countSubstrings(s, i, i + 1);
        }
        return result;
    }

    private int countSubstrings(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i++) == s.charAt(j--)) {
            count++;
        }
        return count;
    }

    //dp方程
    /*  为true时计数
        1、如果i==j 表示一个字符，默认为true
        2、如果s.charAt(i) == s.charAt(j)时
               a、i - j == 1 为true （代表2个字符一样）
               b、dp[j + 1][i - 1] == true  那么说明之前的也是true，否则为false
     */
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int result = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++)
                if (i == j || (s.charAt(i) == s.charAt(j) && (i - j == 1 || dp[j + 1][i - 1]))) {
                    dp[j][i] = true;
                    result++;
                }
        }
        return result;
    }

    public static void main(String[] args) {
        new LeetCode_647_693().countSubstrings("aabbcc");
    }
}
