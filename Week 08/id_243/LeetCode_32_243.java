/**
 * @author eazonshaw
 * @date 2019/12/8  22:22
 */
public class LeetCode_32_243 {


    //dp
    //状态数组 dp[i]
    //状态方程：
    //1.当i为右括号且i-1为左括号时，dp[i] = dp[i-2] + 2
    //2.当i为右括号，i-1也为右括号，且i-dp[i-1]-1为左括号时，dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
    public int longestValidParentheses(String s) {
        int max = 0;
        //状态数组
        int[] dp = new int[s.length()];
        //状态方程
        for(int i = 1;i < s.length();i++){
            //当i为右括号
            if(s.charAt(i) == ')'){
                //i-1为左括号
                if(s.charAt(i-1) == '('){
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                }else if(i - dp[i - 1] > 0  && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + (i-dp[i-1]>=2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }



}
