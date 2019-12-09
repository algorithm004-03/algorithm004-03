//438. 找到字符串中所有字母异位词

//解法1：暴力解法 	执行用时：569ms
//思路：
public List<Integer> findAnagrams(String s, String p) {
	List<Integer> res = new ArrayList<>();
	if (s.length() < p.length()) return res;
	char[] pArr = p.toCharArray();
	for (int i = 0; i <= s.length() - p.length(); i++) {
		char[] temp = s.substring(i, i + p.length()).toCharArray();
		if (isAnagrams(temp, pArr)) {
			res.add(i);
		}
	}
	return res;
}

private boolean isAnagrams(char[] temp1, char[] temp2) {
	int[] count = new int[26];
	for (int i = 0; i < temp1.length; i++) {
		count[temp1[i] - 'a']++;
		count[temp2[i] - 'a']--;
	}
	for (int i = 0; i < count.length; i++) {
		if (count[i] != 0) return false;
	}
	return true;
}