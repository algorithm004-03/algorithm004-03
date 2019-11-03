//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        //使用暴力法进行先排序，再看是否相同
//		char[] chars1 = s.toCharArray();
//		char[] chars2 = t.toCharArray();
//		Arrays.sort(chars1);
//		Arrays.sort(chars2);
//		return Arrays.equals(chars1,chars2);
		//2、使用哈希表
		if (s.length() != t.length()) {
			return false;
		}
		//思路是里面只有小写字母a-z,那么可以弄一个计数器表
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			//对于s里面的每个进行++
			counter[s.charAt(i) - 'a']++;
			//对于s里面的每个计数进行--
			counter[t.charAt(i) - 'a']--;
		}
		//最后这个计数器里面的值要全部变成0，否则就是false
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
