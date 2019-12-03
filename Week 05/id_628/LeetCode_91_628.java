//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_91_628 {
    public int numDecodings(String s) {
        //边界条件
        if(s == null || s.length()==0)return -1;
        //定义dp数组--编码方法总数
        int n = s.length();
        int[] dp = new int[n+1];
        //初始化dp数组
        //--空串
        dp[0] = 1;
        //--以0开头不支持编码
        dp[1] = (s.charAt(0) == '0') ? 0 : 1 ;
        //状态转移方程
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i-1,i));
            int two = Integer.valueOf(s.substring(i-2,i));
            if (one >= 1 && one <= 9){
                dp[i] = dp[i] + dp[i-1];
            }
            if(two >=10 && two <= 26){
                dp[i] = dp[i] + dp[i-2];
            }

        }
        
        return dp[s.length()];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
