package test1.week5;

public class LeetCode_91_638 {

    /**
     * 解码方法
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        //dp[i] dp[i+1] <= 26
        //dp[-1] = dp[0] = 1
        char[] dp = s.toCharArray();
        if (dp[0] == '0') return 0;
        int pre = 1, curr = 1;
        for (int i = 1; i < dp.length;i++) {
            int tmp = curr;
            if (dp[i] == '0')
                if (dp[i - 1] == '1' || dp[i - 1] == '2') curr = pre;
                else return 0;
            else if (dp[i - 1] == '1' || (dp[i - 1] == '2' && dp[i] >= '1' && dp[i] <= '6'))
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }
}
