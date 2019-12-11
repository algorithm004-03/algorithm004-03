//17. 电话号码的字母组合

//解法1：递归组合字符串		执行用时击败约98%
//思路：在每一层递归函数中获取digits对应的letters,然后letters中的所有字母再组合下一层递归中的letters, 直到所有的digits对应的letters都组合完毕
//时间复杂度O(3^N * 4^M) 3、4为letters的个数, N,M为digits的长度
//空间复杂度O(3^N * 4^M)
private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

public List<String> letterCombinations2(String digits) {
	List<String> res = new ArrayList<>();
	if (digits == "" || digits == null) {
		return res;
	}
	combine("", digits, 0, res);
	return res;
}

private void combine(String str, String digits, int offset, List<String> list) {
	if (offset >= digits.length()) {
		list.add(str);
		return;
	}
	int index = digits.charAt(offset) - '0';
	String letters = KEYS[index];
	for (int i = 0; i<letters.length(); i++) {
		combine(str + letters.charAt(i), digits, offset + 1, list);
	}
}


//对于解法1的不同实现
public List<String> letterCombinations(String digits) {
	if (digits == null || digits.equals("")) return new ArrayList<>();
	HashMap<Character, String> map = new HashMap<>();
	map.put('2', "abc");
	map.put('3', "def");
	map.put('4', "ghi");
	map.put('5', "jkl");
	map.put('6', "mno");
	map.put('7', "pqrs");
	map.put('8', "tuv");
	map.put('9', "wxyz");
	List<String> list = new ArrayList<>();
	combination(map, 0, list, digits, "");
	return list;
}

private void combination(HashMap<Character, String> map, int offset, List<String> list, String digits, String res) {
	if (offset == digits.length()) {
		list.add(res);
		return;
	}
	String letters = map.get(digits.charAt(offset));
	for (int i = 0; i < letters.length(); i++) {
		combination(map, offset + 1, list, digits, res + letters.charAt(i));
	}
}
