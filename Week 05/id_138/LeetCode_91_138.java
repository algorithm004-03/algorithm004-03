/**
 * 解码方法 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *  输入: "12" 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）
 * 
 * @author L
 *
 */
public class LeetCode_91_138 {
	/**
	 * 类似爬楼梯
	 * 动态规划思路 1)重复子问题 
	 * 2)dp状态定义dp[i] = s(i....N)的解码方法数
	 * 3)dp方程 dp[i] = dp[i-1] ||  dp[i-1]+dp[i-2](条件)
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if(s==null || s.length() == 0 || s.startsWith("0"))
			return 0;
		int len = s.length();
		int[] dp = new int[len+1];
		dp[len] = 1;
		if(s.charAt(len-1) == '0') {
			dp[len-1] = 0;//0的解码个数为0
		}else {
			dp[len-1] = 1;//非0的解码个数为1
		}
		for(int i=len-2;i>=0;i--) {
			if(s.charAt(i) == '0') {
				dp[i] = 0;
				continue;
			}
			
			if((s.charAt(i) -'0')*10 +(s.charAt(i+1)-'0') <= 26) {//当前i位置与i+1位置组合的数字是否<=26
				dp[i] = dp[i+1] + dp[i+2];
			}else {
				dp[i] = dp[i+1];
			}
		}
		
		return dp[0];
	}

}
