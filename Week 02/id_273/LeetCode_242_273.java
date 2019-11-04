//242. 有效的字母异位词


//解法1：排序比较法		执行用时击败约51%
//思路：将s和t转换为数组，然后比较排序后两个数组是否相同
//时间复杂度O(nlogN)
public static boolean isAnagram2(String s, String t) {
	if (s.length() != t.length()) return false;
	char temp1[] = s.toCharArray();
	char temp2[] = t.toCharArray();
	Arrays.sort(temp1);
	Arrays.sort(temp2);
	return Arrays.equals(temp1,temp2);
}

//解法2：数组映射法		执行用时击败约99%
//思路：创建一个包含26位字符的数组，用于存储字符串中26个字符出现的次数
//时间复杂度O(n)
//空间复杂度O(n)
//总结：程序也可以不将字符串转换为数组直接判断, 但是效率并不高, 执行用时会多出大约4ms, 这里通过创建数组并直接对数组进行操作, 因此减少了一些运算量 
public boolean isAnagram(String s, String t) {
	char[] arr1 = s.toCharArray();
	char[] arr2 = t.toCharArray();
	if (s.length() != t.length()) return false;
	int[] temp = new int['z' + 1];
	for (int i = 0; i < arr1.length(); i++) {
		temp[arr1[i]]++;
		temp[arr2[i]]--;
	}
	for (int a : temp) {
		if (a != 0) return false;
	}
	return true;
}