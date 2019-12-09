//771. 宝石与石头

//解法1：暴力	执行用时：1ms
//思路：遍历宝石的所有字符, 观察都在石头中出现了几次
//		因为题目给定宝石不会重复, 所以该解法是可行的, 否则不通过
//时间复杂度：O(J.Length * S.Length)
//空间复杂度：O(1)
public int numJewelsInStones(String J, String S) {
	int count = 0;
	for (char c1 : J.toCharArray()) {
		for (char c2 : S.toCharArray()) {
			if (c1 == c2) count++;
		}
	}
	return count;
}