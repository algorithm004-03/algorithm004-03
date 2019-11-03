/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class LeetCode_242_588 {

    /**
     * 思路：
     * 可以计算两个字符串中每个字母的出现次数并进行比较，用一个计数器表计算s字母的频率，用t减少计数器表中的每个字母的计数器，然后检查计数器是否回到零
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for (int j = 0; j < counter.length; j ++) {
            if (0 != counter[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "abdacb";
        String t = "caabbd";
        String q = "abcdef";
        LeetCode_242_588 solution = new LeetCode_242_588();
        System.out.println(solution.isAnagram(s, t));
        System.out.println(solution.isAnagram(s, q));
    }
}
