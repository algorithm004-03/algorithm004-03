//32. 最长的有效括号


//解法1：栈
//思路：首先要明确一组字符串, 它的有效括号与无效括号概念, 例如：")()(()" 就只存在一组有效括号"()", 长度为2, "(()" 缺少右括号组成一组有效括号
//		可以通过栈维护未组成有效括号的字符的index, 若当前获取到一个能与栈顶元素对应的字符组成有效括号的字符, 那么更新最大有效长度
//代码流：s = "")()(())"	index = 0  	stack [ -1, 0 ]		count = 0;
//							index = 1	stack [ -1, 0, 1 ]	count = 0;
//							index = 2	stack [ -1, 0, ]	count = 2 - 0;
//							index = 3 	stack [ -1, 0, 3 ] 	count = 2;
//							index = 4	stack [ -1, 0, 3, 4 ]   count = 2;
//							index = 5	stack [ -1, 0, 3 ]	count = 5 - 3 = 2;
//							index = 6 	stack [ -1, 0 ]		count = 6 - 0 = 6;
//时间复杂度：O(n)
//空间复杂度：O(n)
public int longestValidParentheses(String s) {
	Stack<Integer> stack = new Stack<>();
	int left = -1;
	int count = 0;
	stack.push(left);
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
			stack.pop();
			count = Math.max(count, i - stack.peek());
		} else {
			stack.push(i);
		}
	}
	return count;
}