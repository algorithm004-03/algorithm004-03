import java.util.Arrays;

/**
 * LeetCode_242_153 https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode_242_153 {

  /**
   * 如果两个字符串长度不相等，一定不是异或词。 将字符串排序，排序后的结果相等，则为异或词
   * 
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] alpha = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alpha[s.charAt(i) - 'a']++;
      alpha[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] != 0) {
        return false;
      }
    }
    return true;
  }
}