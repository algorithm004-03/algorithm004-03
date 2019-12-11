//205. 重构字符串

//解法1：		执行用时：8ms
//思路：
public boolean isIsomorphic(String s, String t) {
	int[] counter1 = new int[256];
	int[] counter2 = new int[256];
	for (int i = 0; i < s.length(); i++) {
		if (counter1[s.charAt(i)] != counter2[t.charAt(i)]) return false;
		counter1[s.charAt(i)] = i + 1;
		counter2[t.charAt(i)] = i + 1;
	}
	return true;
}