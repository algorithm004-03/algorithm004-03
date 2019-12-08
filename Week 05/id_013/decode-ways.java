public int numDecodings4(String s) {
    int len = s.length();
    int[] dp = new int[3];
    dp[len % 3] = 1;
    if (s.charAt(len - 1) != '0') {
        dp[(len - 1) % 3] = 1;
    }
    for (int i = len - 2; i >= 0; i--) {
        if (s.charAt(i) == '0') {
            dp[i % 3] = 0; //因为空间复用了，不要忘记归零
            continue;
        }
        int ans1 = dp[(i + 1) % 3];
        int ans2 = 0;
        int ten = (s.charAt(i) - '0') * 10;
        int one = s.charAt(i + 1) - '0';
        if (ten + one <= 26) {
            ans2 = dp[(i + 2) % 3];
        }
        dp[i % 3] = ans1 + ans2;

    }
    return dp[0];
}
