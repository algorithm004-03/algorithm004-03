import java.util.Stack;

/**
 * 最长的有效括号的长度
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @author L
 *
 */
public class LeetCode_32_138 {
	
	/**
	 * 暴力法:计算当前位置开始的元素的最大有效长度与历史有效长度比较
	 * O(n^2)
	 * @param s
	 * @return
	 */
	public int longestValidParentheses_solution1(String s) {
		int max = 0;
		for(int i=0;i<s.length();i++) {
			for(int j=i+2;j<s.length();j+=2) {
				String temp = s.substring(i,j);
				if(isValid(temp)) {
					max = Math.max(max, j-i);
				}
			}
		}
		return max;
	}
	
	/**
	 * 判断是否有效括号字符串
	 * @param str
	 * @return
	 */
	private boolean isValid(String str) {
		Stack<Character> stack = new Stack();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'c') {
				stack.push('c');
			}else if(!stack.isEmpty() && stack.peek() == '(') {
				stack.pop();//当前str.charAt(i)是')'
			}else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 动态规划：dp[i] :以下标为i的字符结尾的最长有效字符串的长度,即以')'结尾的下标在数组中的值必定为0.
	 * @param s
	 * @return
	 */
	public int longestValidParentheses_solution2(String s) {
		int max = 0;
		int len = s.length();
		int dp[] = new int[len];//数组初始值全部为0
		for(int i=1;i<len;i++) {
			if(s.charAt(i) == ')') {
				if(s.charAt(i-1) == '(') {
					dp[i] = (i>=2?dp[i-2]:0)+2;//()必须是一对才有效，所以判断从i>=2开始
				}else if(i-dp[i-1] >0 && s.charAt(i-dp[i-1]-1) == '(') {//判断前一个最大子串的左侧位置是否是'('
					dp[i] = dp[i-1] + ( (i-dp[i-1])>=2 ? dp[i-dp[i-1]-2]:0 ) + 2;
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
	
}
