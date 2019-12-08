class Solution {
	// 数字和字母的映射表
	private Map<String, String> phoneLetters = new HashMap<>(8, 1);
	// 结果集
	private List<String> ret = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		// 处理空值
		if (digits.length() == 0) {
			return ret;
		}

		// 构建映射表
		this.buildPhoneLetters();

		// 开始执行，初始字母为空，起始为0
		this.letterCombinations("", digits, 0);

		return this.ret;
	}

	/**
	 * 获取digitIndex位置的数字，获取对应字母，将每个字母追加到当前字母上，继续递归，直到最后一个数字
	 * 
	 * @param letters
	 * @param digits
	 * @param digitIndex
	 */
	private void letterCombinations(String letters, String digits, int digitIndex) {
		if (digitIndex == digits.length()) {
			ret.add(letters.toString());

			return;
		}

		String digit = String.valueOf(digits.charAt(digitIndex));
		String phoneLetter = phoneLetters.get(digit);

		for (int j = 0; j < phoneLetter.length(); j++) {
			String letter = String.valueOf(phoneLetter.charAt(j));

			this.letterCombinations(letters + letter, digits, digitIndex + 1);
		}

	}

	private void buildPhoneLetters() {
		phoneLetters.put("2", "abc");
		phoneLetters.put("3", "def");
		phoneLetters.put("4", "ghi");
		phoneLetters.put("5", "jkl");
		phoneLetters.put("6", "mno");
		phoneLetters.put("7", "pqrs");
		phoneLetters.put("8", "tuv");
		phoneLetters.put("9", "wxyz");
	}
}