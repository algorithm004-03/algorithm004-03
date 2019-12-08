package study;

public class LeeCode_091_108 {

	public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
        System.out.println(new LeeCode_091_108().numDecodings("12"));
	}

}
