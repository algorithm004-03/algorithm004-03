//58. 最后一个单词的长度

//解法1：暴力解法	执行用时：2ms
//思路：遍历字符串, 每一次遇到新的单词的时候都重新统计单词的长度
//		新的单词意味着前一位字符是空格
public int lengthOfLastWord(String s) {
	if (s.length() == 0 || s == null) return 0;
	char[] temp = s.toCharArray();
	int count = 0;
	for (int i = 0; i < temp.length; i++) {
		if (temp[i] == ' ') continue;
		if (i > 0 && temp[i] != ' ' && temp[i - 1] == ' ') count = 0;
		count++;
	}
	return count;
}