//14. 最常公共前缀

//解法1：	执行用时：0ms
//思路：因为最长公共前缀最长也就是字符串数组中最短的那个字符串
//		因此取字符串数组的首位为"标杆", 然后遍历整个字符串数组, 如果存在以"标杆"打头的字符串, 那么"标杆"就是最长公共前缀
//		如果遍历完整个数组都不存在, 那么"标杆"取0~length - 1位继续比较
//时间复杂度：O(strs.length * Max((String s : strs).length)
//空间复杂度：O(Max((String s : strs).length) //如果按字符串为数组为前提进行计算的话是这个复杂度
public String longestCommonPrefix(String[] strs) {
	if (strs.length == 0 || strs == null) return "";
	String pre = strs[0];
	for (int i = 1; i < strs.length; i++) {
		while (!strs[i].startsWith(pre)) {
			pre = pre.substring(0, pre.length() - 1);
		}
	}
	return pre;
}