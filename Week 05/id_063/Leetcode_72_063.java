/*
思路

将状态dp[i][j]定义为word1前0-i下标字符组成的子串转换成
word2 0-j下标字符组成的子串需要的最少步骤

如果i和j位置上字符是相同的，那么dp[i][j] = dp[i-1][j-1]
如果i j 字符不同
    有几种操作：
    把 i 字符换成 j 字符，word1[0:i-1] 再转换成 word2[0:j-1]  最少操作 1 + dp[i-1][j-1]次
    把 i 字符删掉 word1[0:i-1] 再转换成 word2[0:j]  最少操作 1 + dp[i-1][j] 次
    把 i 位置后面加一个j字符，word1[0:i] 再转换成 word2[0:j-1], 最少操作 1 + dp[i][j-1]次
    三种里面取最少的一个，进行递推
 */

class Solution {
    public int minDistance(String word1, String word2) {
        if ((word1.length() == 0) || (word2.length() == 0)) {
            return Math.max(word1.length(), word2.length());
        }

        int[] dp_old = new int[word2.length()];
        int[] dp_new = new int[word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            if (i == 0) {
                boolean flag = false;       // 标志word1.charAt(0)在word2出现没有
                for (int j = 0; j < word2.length(); j++) {
                    if (word2.charAt(j) == word1.charAt(0)) {
                        flag = true;
                    }

                    dp_new[j] = (flag) ? j : j+1;
                }
            } else {
                boolean flag = false;
                for (int ii = 0; ii <= i; ii++) {
                    if (word1.charAt(ii) == word2.charAt(0)) {
                        flag = true;
                        break;
                    }
                }
                dp_new[0] = (flag) ? i : i+1;

                for (int j = 1; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp_new[j] = dp_old[j-1];
                    } else {
                        dp_new[j] = Math.min(dp_old[j-1], dp_old[j]);
                        dp_new[j] = Math.min(dp_new[j-1], dp_new[j]);
                        dp_new[j] = dp_new[j] + 1;
                    }
                }
            }

            int[] dp_tmp = dp_old;
            dp_old = dp_new;
            dp_new = dp_tmp;
        }

        return dp_old[word2.length()-1];
    }
}
