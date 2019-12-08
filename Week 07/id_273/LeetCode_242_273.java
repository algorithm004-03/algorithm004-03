//242. 有效的字母异位词


//解法1：排序比较法		执行用时：5ms
//思路：将s和t转换为数组，然后比较排序后两个数组是否相同
//时间复杂度O(nlogN)
public boolean isAnagram(String s, String t) {
	if (s.length() != t.length()) return false;
	char temp1[] = s.toCharArray();
	char temp2[] = t.toCharArray();
	Arrays.sort(temp1);
	Arrays.sort(temp2);
	return Arrays.equals(temp1,temp2);
}

//解法2：数组映射法		执行用时：2ms
//思路：创建一个包含26位字符的数组，用于存储字符串中26个字符出现的次数
//时间复杂度O(n)
//空间复杂度O(n)
 public boolean isAnagram(String s, String t) {
	if (s.length() != t.length()) return false;
	char[] sc = s.toCharArray();
	char[] tc = t.toCharArray();
	int[] temp = new int[26];
	for (int i = 0; i < sc.length; i++) {
		temp[sc[i] - 'a']++;
		temp[tc[i] - 'a']--;
	}
	for (int i = 0; i < temp.length; i++) {
		if (temp[i] != 0) return false; 
	}
	return true;
}