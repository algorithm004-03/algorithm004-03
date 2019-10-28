//20. 有效括号

//解法1：辅助栈
//时间复杂度O(n)
//空间复杂度O(n) 额外开辟了一个栈，当s字符串全为右括号时，栈大小为s.length()
public void isValid(String s) {
	//若长度为奇数 可以直接判定不有效
	if(s.length()%2 != 0) return false;
	
	HashMap<Character, Character> map = new HashMap<>();
	map.put(']','[');
	map.put(')','(');
	map.put('}','{');
	Stack<Character> stack = new Stack<>();
	
	for (int i = 0;i<s.length;i++) {
		char c = s.charAt(i);
		//说明是右括号
		if (map.containsKey(c)) {
			char top = stack.isEmpty()?'#':stack.pop();
			if (map.get(c) != top) {
				return false;
			}
		} else {//说明是左括号
			stack.push();
		}
	}
	return stack.isEmpty();
}