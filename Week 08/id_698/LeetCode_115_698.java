/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 
 * @author gning (id=698)
 */

 public class LeetCode_115_698 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];

        for(int j=0; j<s.length()+1; j++) {
            dp[0][j] = 1;
        }

        for(int i=1; i<t.length()+1; i++) {
            for(int j=1; j<s.length()+1;j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
 }