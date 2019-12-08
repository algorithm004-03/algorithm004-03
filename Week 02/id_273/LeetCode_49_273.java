//49. 字母异位词

//解法1：HashMap	执行用时击败约99%
//思路：使用HashMap, KEY存储经过排序后的异位词字符串, VALUE存储异位词List
//		遍历字符串数组, 判断map中是否包含当前元素的异位词List, 若有直接追加即可, 若没有创建对应的异位词List
//时间复杂度O(KlogK * N), K为单个异位词字符串的长度
//空间复杂度O(N * K)
public List<List<String>> groupAnagrams2(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();
	List<List<String>> result = new ArrayList<>();
	for (int i = 0; i < strs.length; i++) {
		char[] temp = strs[i].toCharArray();
		Arrays.sort(temp);
		String val = String.valueOf(temp);
		if (map.containsKey(val)) {
			map.get(val).add(strs[i]);
		} else {
			List<String> list = new ArrayList<>();
			list.add(strs[i]);
			map.put(val, list);
		}
	}
	return new ArrayList<>(map.values());
}