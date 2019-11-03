//242. 有效的字母异位词

//解法1：首先是强行用HashMap做的解法，效率最低所以放第一个
//思路：先将s存入HashMap，若出现重复value值+1，然后在map中查看是否包含t，找到时value-1，若value=1则移除key，若map最后为空说明有效。
//时间复杂度O(n)，虽然和解法3时间复杂度相同，但是内部涉及到了大量的map操作
public static boolean isAnagram1(String s, String t) {
	if (s.length() != t.length()) return false;
	Map<Character,Integer> map = new HashMap<>();
	
	for (char c : s.toCharArray()) {
		Integer count = map.get(c);
		//如果已经包含了该字符 value+1即可
		if (map.containsKey(c)) {
			map.put(c,++count);
			continue;
		}
		if (count == null) {
			map.put(c,1);
		}
	}

	for (char c : t.toCharArray()) {
		Integer count = map.get(c);
		if (count == null) {
			//说明不存在该字符
			return false;
		} else if (count > 1) {
			map.put(c,--count);
		} else {
			map.remove(c);
		}
	}
	return map.isEmpty();
}

//解法2：排序比较法
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

//解法3：数组映射法
//思路：创建一个包含26位字符的数组，用于存储字符串中26个字符出现的次数
//时间复杂度O(n)
public static boolean isAnagram3(String s, String t) {
	if (s.length() != t.length()) return false;
	int[] temp = new int[26];
	for (int i = 0;i<s.length();i++) {
		temp[s.charAt(i) - 'a']++;
		temp[t.charAt(i) - 'a']--;
	}
	for (int i = 0;i<s.length();i++) {
		if (temp[i] != 0) {
			return false;
		}
	}
	return true;
}

